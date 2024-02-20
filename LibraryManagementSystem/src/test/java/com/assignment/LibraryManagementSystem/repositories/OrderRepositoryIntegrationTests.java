package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Book;
import com.assignment.LibraryManagementSystem.domain.Order;
import com.assignment.LibraryManagementSystem.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderRepositoryIntegrationTests {

    private UserRepository userRepo;
    private BookRepository bookRepo;
    private OrderRepository underTest;

    @Autowired
    public OrderRepositoryIntegrationTests(OrderRepository underTest, UserRepository userDao, BookRepository bookDao){
        this.underTest = underTest;
        this.userRepo = userDao;
        this.bookRepo = bookDao;
    }

    @Test
    public void testThatOrderCreatedAndRecalled() throws ParseException {
        Book book = TestDataUtil.createTestBookA();
        User user = TestDataUtil.createTestUserA();
        bookRepo.save(book);
        userRepo.save(user);
        Order order = TestDataUtil.createTestOrderA(book, user);
        underTest.save(order);
        Optional<Order> result = underTest.findById(order.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(order);
    }

//    @Test
//    public void testThatMultipleOrdersCanBeCreatedAndRecalled() throws ParseException {
//        Book book = TestDataUtil.createTestBookA();
//        User user = TestDataUtil.createTestUserA();
//        bookDao.create(book);
//        userDao.create(user);
//        Order orderA = TestDataUtil.createTestOrderA();
//        Order orderB = TestDataUtil.createTestOrderB();
//
//        underTest.create(orderA);
//        underTest.create(orderB);
//        List<Order> results = underTest.find();
//        assertThat(results).hasSize(2).containsExactly(orderA, orderB);
//    }
//
//
//    @Test
//    public void testThatOrdersCanBeUpdatedAndRecalled() throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        Book book = TestDataUtil.createTestBookA();
//        User user = TestDataUtil.createTestUserA();
//        bookDao.create(book);
//        userDao.create(user);
//        Order orderA = TestDataUtil.createTestOrderA();
//        underTest.create(orderA);
//        orderA.setIssue_date(formatter.parse("12-OCT-2010"));
//        underTest.update(orderA.getId(), orderA);
//        Optional<Order> result = underTest.findOne(orderA.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(orderA);
//    }
//
//    @Test
//    public void testThatOrderCanBeDeleted() throws ParseException{
//        Book book = TestDataUtil.createTestBookA();
//        User user = TestDataUtil.createTestUserA();
//        bookDao.create(book);
//        userDao.create(user);
//        Order orderA = TestDataUtil.createTestOrderA();
//        underTest.create(orderA);
//        underTest.delete(orderA.getId());
//        Optional<Order> result = underTest.findOne(orderA.getId());
//        assertThat(result).isEmpty();
//    }
}
