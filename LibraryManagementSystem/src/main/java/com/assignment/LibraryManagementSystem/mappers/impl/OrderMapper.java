package com.assignment.LibraryManagementSystem.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.assignment.LibraryManagementSystem.domain.dto.OrderDto;
import com.assignment.LibraryManagementSystem.domain.entities.OrderEntity;
import com.assignment.LibraryManagementSystem.mappers.Mapper;

@Component
public class OrderMapper implements Mapper<OrderEntity, OrderDto> {

    private ModelMapper modelMappper;
    
    public OrderMapper(ModelMapper modelMapper) {
        this.modelMappper = modelMapper; 
    }

    @Override
    public OrderDto mapTo(OrderEntity orderEntity) {
        return modelMappper.map(orderEntity, OrderDto.class); 
    }

    @Override
    public OrderEntity mapFrom(OrderDto orderDto) {
        return modelMappper.map(orderDto, OrderEntity.class); 
    }
    
}
