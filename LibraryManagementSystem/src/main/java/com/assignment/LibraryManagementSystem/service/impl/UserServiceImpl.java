package com.assignment.LibraryManagementSystem.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;
import com.assignment.LibraryManagementSystem.repositories.UserRepository;
import com.assignment.LibraryManagementSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createAdmin(UserEntity userEntity) {
        userEntity.setRole("admin");
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setRole("user");
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAllAdmins() {
        return userRepository.findAllUsersBasedOnRole("admin");
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAllUsersBasedOnRole("user");
    }

}
