package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Admin;
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
public class AdminDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AdminDaoImpl underTest;


    @Test
    public void testThatCreateAdminGeneratesCorrectSql(){
        Admin admin = TestDataUtil.createTestAdminA();
        underTest.create(admin);
        verify(jdbcTemplate).update(
                eq("INSERT INTO admins (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("admin1"), eq(20)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from admins where id = ? LIMIT 1"),
                ArgumentMatchers.<AdminDaoImpl.AdminRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age from admins"),
                ArgumentMatchers.<AdminDaoImpl.AdminRowMapper>any()
        );
    }
}
