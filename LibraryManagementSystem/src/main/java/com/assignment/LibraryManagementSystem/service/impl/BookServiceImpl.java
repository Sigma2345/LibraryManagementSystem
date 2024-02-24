package com.assignment.LibraryManagementSystem.service.impl;

import org.springframework.stereotype.Service;

import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import com.assignment.LibraryManagementSystem.repositories.BookRepository;
import com.assignment.LibraryManagementSystem.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity bookEntity) {
        bookEntity.setIsbn(isbn);        
        return bookRepository.save(bookEntity); 
    }
    
}
