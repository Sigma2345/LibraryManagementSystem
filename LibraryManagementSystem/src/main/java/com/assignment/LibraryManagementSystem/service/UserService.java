package com.assignment.LibraryManagementSystem.service;

import java.util.List;

import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    UserEntity createAdmin(UserEntity userEntity); 

    List<UserEntity> findAllAdmins();

    List<UserEntity> findAllUsers(); 
}
