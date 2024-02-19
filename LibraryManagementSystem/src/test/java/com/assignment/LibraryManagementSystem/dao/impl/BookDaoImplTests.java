package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate ;

    @InjectMocks
    private BookDaoImpl underTest ;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, quantity) VALUES (?, ?, ?)"),
                eq("1234"), eq("Book 1"), eq(1)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne("1234");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, quantity from books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("1234")
        );
    }
}
