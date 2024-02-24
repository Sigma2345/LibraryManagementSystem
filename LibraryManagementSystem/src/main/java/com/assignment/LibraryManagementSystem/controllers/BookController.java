package com.assignment.LibraryManagementSystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.LibraryManagementSystem.domain.dto.BookDto;
import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import com.assignment.LibraryManagementSystem.mappers.Mapper;
import com.assignment.LibraryManagementSystem.service.BookService;

@RestController
public class BookController {

    private BookService bookService;
    private Mapper<BookEntity, BookDto> bookMapper;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(
        @PathVariable("isbn") String isbn, 
        @RequestBody BookDto bookDto
    ) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createBook(isbn, bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity); 
        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED); 
    }

}
