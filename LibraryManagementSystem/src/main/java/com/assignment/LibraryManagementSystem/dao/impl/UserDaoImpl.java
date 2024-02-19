package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.dao.UserDao;
import com.assignment.LibraryManagementSystem.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate ;
    public UserDaoImpl(final JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }

    @Override
    public void create(User user){
        jdbcTemplate.update(
                "INSERT INTO users (id, name, age) VALUES (?, ?, ?)",
                user.getId(), user.getName(), user.getAge()
        );
    }

    @Override
    public Optional<User> findOne(long userId){
        List<User> results = jdbcTemplate.query(
                "SELECT id, name, age from users where id = ? LIMIT 1",
                new UserDaoImpl.UserRowMapper(), userId
        );
        return results.stream().findFirst();
    }

    public static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
