package com.assignment.LibraryManagementSystem.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.LibraryManagementSystem.domain.dto.UserDto;
import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;
import com.assignment.LibraryManagementSystem.mappers.Mapper;
import com.assignment.LibraryManagementSystem.service.UserService;

@RestController
public class UserController {
    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping(path = "/users/admin")
    public ResponseEntity<UserDto> createAdmin(@RequestBody UserDto user) {
        UserEntity adminEntity = userMapper.mapFrom(user);
        UserEntity savedAdminEntity = userService.createAdmin(adminEntity);
        return new ResponseEntity<>(userMapper.mapTo(savedAdminEntity), HttpStatus.CREATED);
    }

    @PostMapping(path = "/users/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserEntity adminEntity = userMapper.mapFrom(user);
        UserEntity savedAdminEntity = userService.createUser(adminEntity);
        return new ResponseEntity<>(userMapper.mapTo(savedAdminEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/users/admins")
    public List<UserDto> listAdmins() {
        List<UserEntity> users = userService.findAllAdmins();
        return users.stream().map(userMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "users/users")
    public List<UserDto> listUsers() {
        List<UserEntity> users = userService.findAllUsers();
        return users.stream().map(userMapper::mapTo).collect(Collectors.toList());        
    }
}
