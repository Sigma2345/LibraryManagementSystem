package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
