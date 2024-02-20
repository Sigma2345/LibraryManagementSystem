package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
