package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.dao.AdminDao;
import com.assignment.LibraryManagementSystem.domain.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AdminDaoImpl implements AdminDao {

    private final JdbcTemplate jdbcTemplate ;
    public AdminDaoImpl(final JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }

    @Override
    public void create(Admin admin){
        jdbcTemplate.update(
                "INSERT INTO admins (id, name, age) VALUES (?, ?, ?)",
                admin.getId(), admin.getName(), admin.getAge()
        );
    }

    @Override
    public Optional<Admin> findOne(long adminId){
        List<Admin> results = jdbcTemplate.query(
                "SELECT id, name, age from admins where id = ? LIMIT 1",
                new AdminRowMapper(), adminId
        );
        return results.stream().findFirst();
    }

    @Override
    public List<Admin> find(){
        List<Admin> results = jdbcTemplate.query(
                "SELECT id, name, age from admins",
                new AdminRowMapper()
        );
        return results.stream().toList();
    }

    public static class AdminRowMapper implements RowMapper<Admin> {

        @Override
        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Admin.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
