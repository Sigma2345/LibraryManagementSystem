package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
