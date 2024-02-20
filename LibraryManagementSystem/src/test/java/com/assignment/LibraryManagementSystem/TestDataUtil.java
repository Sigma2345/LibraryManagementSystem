package com.assignment.LibraryManagementSystem;


import com.assignment.LibraryManagementSystem.domain.Admin;
import com.assignment.LibraryManagementSystem.domain.Book;
import com.assignment.LibraryManagementSystem.domain.Order;
import com.assignment.LibraryManagementSystem.domain.User;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class TestDataUtil {

    private TestDataUtil(){}

    public static Admin createTestAdminA() {
        return Admin.builder()
                .id(1L)
                .name("admin1")
                .age(20)
                .build();
    }

    public static Admin createTestAdminB() {
        return Admin.builder()
                .id(2L)
                .name("admin2")
                .age(20)
                .build();
    }

    public static Admin createTestAdminC() {
        return Admin.builder()
                .id(3L)
                .name("admin3")
                .age(20)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("1234")
                .title("Book 1")
                .quantity(1)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("2345")
                .title("Book 2")
                .quantity(1)
                .build();
    }

    public static Order createTestOrderA(Book book, User user) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return Order.builder()
                .id(1L)
                .book(book)
                .user(user)
                .issue_date(formatter.parse("10-OCT-2010"))
                .expiration_date(formatter.parse("20-OCT-2010"))
                .return_date(formatter.parse("24-OCT-2010"))
                .fine(10)
                .build();
    }

    public static Order createTestOrderB() throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return Order.builder()
                .id(2L)
                .issue_date(formatter.parse("20-OCT-2010"))
                .expiration_date(formatter.parse("30-OCT-2010"))
                .return_date(formatter.parse("31-OCT-2010"))
                .fine(20)
                .build();
    }

    public static User createTestUserA() {
        return User.builder()
                .id(1L)
                .name("user1")
                .age(20)
                .build();
    }

    public static User createTestUserB() {
        return User.builder()
                .id(2L)
                .name("user2")
                .age(20)
                .build();
    }
}
