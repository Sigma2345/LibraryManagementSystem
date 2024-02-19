package com.assignment.LibraryManagementSystem;


import com.assignment.LibraryManagementSystem.domain.Admin;
import com.assignment.LibraryManagementSystem.domain.Book;
import com.assignment.LibraryManagementSystem.domain.Order;
import com.assignment.LibraryManagementSystem.domain.User;

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

    public static Book createTestBook() {
        return Book.builder()
                .isbn("1234")
                .title("Book 1")
                .quantity(1)
                .build();
    }

    public static Order createTestOrder() throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        return Order.builder()
                .id(1L)
                .book_id("1234")
                .user_id(1L)
                .issue_date(formatter.parse("10-OCT-2010"))
                .expiration_date(formatter.parse("20-OCT-2010"))
                .return_date(formatter.parse("24-OCT-2010"))
                .fine(10)
                .build();
    }

    public static User createTestUser() {
        return User.builder()
                .id(1L)
                .name("user1")
                .age(20)
                .build();
    }
}
