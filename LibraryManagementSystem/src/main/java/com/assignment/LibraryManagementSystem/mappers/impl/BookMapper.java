package com.assignment.LibraryManagementSystem.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.assignment.LibraryManagementSystem.domain.dto.BookDto;
import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import com.assignment.LibraryManagementSystem.mappers.Mapper;

@Component
public class BookMapper implements Mapper<BookEntity, BookDto> {
    private ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper; 
    }

    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class); 
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class); 
    }
    
        
}
