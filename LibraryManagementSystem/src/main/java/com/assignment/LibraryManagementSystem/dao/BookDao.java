package com.assignment.LibraryManagementSystem.dao;

import com.assignment.LibraryManagementSystem.domain.Book;

import java.util.Optional;

public interface BookDao {
    void create(Book book);

    Optional<Book> findOne(String bookIsbn);
}
