package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Admin;
import com.assignment.LibraryManagementSystem.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTests(BookDaoImpl underTest){this.underTest = underTest; }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);
        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
