package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
