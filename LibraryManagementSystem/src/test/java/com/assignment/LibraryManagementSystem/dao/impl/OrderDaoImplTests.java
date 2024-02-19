package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Book;
import com.assignment.LibraryManagementSystem.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate ;

    @InjectMocks
    private OrderDaoImpl underTest ;

    @Test
    public void testThatCreateOrderGeneratesCorrectSql() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Order order = TestDataUtil.createTestOrder();
        underTest.create(order);
        verify(jdbcTemplate).update(
                eq("INSERT INTO orders (id, book_id, user_id, issue_date, expiration_date, return_date, fine) VALUES (?, ?, ?, ?, ?, ?, ?)"),
                eq(1L), eq("1234"), eq(1L), eq(formatter.parse("10-OCT-2010")),
                eq(formatter.parse("20-OCT-2010")), eq(formatter.parse("24-OCT-2010")), eq(10)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, book_id, user_id, issue_date, expiration_date, return_date, fine from orders WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<OrderDaoImpl.OrderRowMapper>any(),
                eq(1L)
        );
    }
}
