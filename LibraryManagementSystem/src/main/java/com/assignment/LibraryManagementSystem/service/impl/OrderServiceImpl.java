package com.assignment.LibraryManagementSystem.service.impl;

import org.springframework.stereotype.Service;

import com.assignment.LibraryManagementSystem.domain.entities.OrderEntity;
import com.assignment.LibraryManagementSystem.repositories.OrderRepository;
import com.assignment.LibraryManagementSystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity); 
    }
    
}
