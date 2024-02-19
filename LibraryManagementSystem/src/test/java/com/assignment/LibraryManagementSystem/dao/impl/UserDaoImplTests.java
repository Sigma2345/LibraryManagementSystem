package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.User;
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
public class UserDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserDaoImpl underTest;


    @Test
    public void testThatCreateUserGeneratesCorrectSql(){
        User user = TestDataUtil.createTestUser();
        underTest.create(user);
        verify(jdbcTemplate).update(
                eq("INSERT INTO users (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("user1"), eq(20)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from users where id = ? LIMIT 1"),
                ArgumentMatchers.<UserDaoImpl.UserRowMapper>any(),
                eq(1L)
        );
    }
}
