package com.assignment.LibraryManagementSystem.dao;

import com.assignment.LibraryManagementSystem.domain.Order;

import java.util.Optional;

public interface OrderDao {


    void create(Order order);

    Optional<Order> findOne(long orderId);
}
