package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import com.assignment.LibraryManagementSystem.domain.entities.OrderEntity;
import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderEntityRepositoryIntegrationTests {

    private UserRepository userRepo;
    private BookRepository bookRepo;
    private OrderRepository underTest;

    @Autowired
    public OrderEntityRepositoryIntegrationTests(OrderRepository underTest, UserRepository userDao, BookRepository bookDao){
        this.underTest = underTest;
        this.userRepo = userDao;
        this.bookRepo = bookDao;
    }

    @Test
    public void testThatOrderCreatedAndRecalled() throws ParseException {
        BookEntity bookEntity = TestDataUtil.createTestBookA();
        UserEntity userEntity = TestDataUtil.createTestUserA();
        bookRepo.save(bookEntity);
        userRepo.save(userEntity);
        OrderEntity orderEntity = TestDataUtil.createTestOrderA(bookEntity, userEntity);
        System.out.println(orderEntity);
        underTest.save(orderEntity);
        Optional<OrderEntity> result = underTest.findById(orderEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(orderEntity);
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
