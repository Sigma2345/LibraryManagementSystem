package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate ;
    public UserDaoImpl(final JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate; }
}
