package com.assignment.LibraryManagementSystem.dao;

import com.assignment.LibraryManagementSystem.domain.User;

import java.util.Optional;

public interface UserDao {
    void create(User user);

    Optional<User> findOne(long userId);
}
