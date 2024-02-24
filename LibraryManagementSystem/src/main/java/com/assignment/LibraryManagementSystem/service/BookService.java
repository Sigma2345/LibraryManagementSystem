package com.assignment.LibraryManagementSystem.service;

import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;

public interface BookService {
    BookEntity createBook(String isbn, BookEntity bookEntity); 
}
