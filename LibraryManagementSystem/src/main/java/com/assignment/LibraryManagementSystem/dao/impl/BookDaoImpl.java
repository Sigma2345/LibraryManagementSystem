package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.dao.BookDao;
import com.assignment.LibraryManagementSystem.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate ;
    public BookDaoImpl(final JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }

    @Override
    public void create(Book book){
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, quantity) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getQuantity()
        );
    }

    @Override
    public Optional<Book> findOne(String bookIsbn){
        List<Book> results = jdbcTemplate.query(
                "SELECT isbn, title, quantity from books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(), bookIsbn
        );
        return results.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .quantity(rs.getInt("quantity"))
                    .build();
        }
    }
}
