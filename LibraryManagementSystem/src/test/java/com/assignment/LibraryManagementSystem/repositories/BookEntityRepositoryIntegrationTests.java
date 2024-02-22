package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTests(BookRepository underTest){this.underTest = underTest; }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        BookEntity bookEntity = TestDataUtil.createTestBookA();
        underTest.save(bookEntity);
        Optional<BookEntity> result = underTest.findById(bookEntity.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

//    @Test
//    public void testThatBooksCanBeCreatedAndRecalled(){
//        Book bookA = TestDataUtil.createTestBookA();
//        underTest.create(bookA);
//
//        Book bookB = TestDataUtil.createTestBookB();
//        underTest.create(bookB);
//
//        List<Book> results = underTest.find();
//        assertThat(results).hasSize(2).containsExactly(bookA, bookB);
//    }

//    @Test
//    public void testThatBooksCanBeUpdatedAndRecalled(){
//        Book bookA = TestDataUtil.createTestBookA();
//        underTest.create(bookA);
//        bookA.setTitle("title 2");
//        underTest.update(bookA.getIsbn(), bookA);
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(bookA);
//    }
//
//    @Test
//    public void testThatBooksCanBeDeleted(){
//        Book bookA = TestDataUtil.createTestBookA();
//        underTest.create(bookA);
//        underTest.delete(bookA.getIsbn());
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isEmpty();
//    }
}
