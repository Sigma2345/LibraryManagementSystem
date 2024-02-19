package com.assignment.LibraryManagementSystem.dao;

import com.assignment.LibraryManagementSystem.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
    void create(Admin admin);

    Optional<Admin> findOne(long adminId);

    List<Admin> find();
}
