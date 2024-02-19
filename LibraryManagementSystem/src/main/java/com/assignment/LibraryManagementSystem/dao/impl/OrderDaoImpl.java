package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.dao.OrderDao;
import com.assignment.LibraryManagementSystem.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDaoImpl implements OrderDao {

    private final JdbcTemplate jdbcTemplate ;
    public OrderDaoImpl(final JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }

    @Override
    public void create(Order order){
        jdbcTemplate.update(
                "INSERT INTO orders (id, book_id, user_id, issue_date, expiration_date, return_date, fine) VALUES (?, ?, ?, ?, ?, ?, ?)",
                order.getId(), order.getBook_id(), order.getUser_id(), order.getIssue_date(), order.getExpiration_date(), order.getReturn_date(), order.getFine()
        );
    }

    @Override
    public Optional<Order> findOne(long orderId){
        List<Order> results = jdbcTemplate.query(
            "SELECT id, book_id, user_id, issue_date, expiration_date, return_date, fine from orders WHERE id = ? LIMIT 1",
            new OrderRowMapper(), orderId
        );
        return results.stream().findFirst();
    }

    public static class OrderRowMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Order.builder()
                    .id(rs.getLong("id"))
                    .book_id(rs.getString("book_id"))
                    .user_id(rs.getLong("user_id"))
                    .issue_date(rs.getDate("issue_date"))
                    .expiration_date(rs.getDate("expiration_date"))
                    .return_date(rs.getDate("return_date"))
                    .fine(rs.getInt("fine"))
                    .build();
        }
    }
}
