package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.role = ?1")
    List<UserEntity> findAllUsersBasedOnRole(String role);

}
