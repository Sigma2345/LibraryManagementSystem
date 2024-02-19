package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Book;
import com.assignment.LibraryManagementSystem.domain.Order;
import com.assignment.LibraryManagementSystem.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrderDaoImplIntegrationTests {

    private UserDaoImpl userDao;
    private BookDaoImpl bookDao;
    private OrderDaoImpl underTest;

    @Autowired
    public OrderDaoImplIntegrationTests(OrderDaoImpl underTest, UserDaoImpl userDao, BookDaoImpl bookDao){
        this.underTest = underTest;
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @Test
    public void testThatOrderCreatedAndRecalled() throws ParseException {
        Book book = TestDataUtil.createTestBook();
        User user = TestDataUtil.createTestUser();
        bookDao.create(book);
        userDao.create(user);
        Order order = TestDataUtil.createTestOrder();
        underTest.create(order);
        Optional<Order> result = underTest.findOne(order.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(order);
    }

}
