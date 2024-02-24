package com.assignment.LibraryManagementSystem;

import com.assignment.LibraryManagementSystem.domain.dto.BookDto;
import com.assignment.LibraryManagementSystem.domain.entities.BookEntity;
import com.assignment.LibraryManagementSystem.domain.entities.OrderEntity;
import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;

import java.text.ParseException;
import java.time.LocalDate;

public final class TestDataUtil {

    private TestDataUtil(){}

    public static UserEntity createTestAdminA() {
        return UserEntity.builder()
                .id(1L)
                .name("admin1")
                .age(20)
                .role("Admin")
                .build();
    }

    public static UserEntity createTestAdminB() {
        return UserEntity.builder()
                .id(2L)
                .name("admin2")
                .age(50)
                .role("Admin")
                .build();
    }

    public static UserEntity createTestAdminC() {
        return UserEntity.builder()
                .id(3L)
                .name("admin3")
                .age(60)
                .role("Admin")
                .build();
    }

    public static BookEntity createTestBookA() {
        return BookEntity.builder()
                .isbn("1234")
                .title("Book 1")
                .quantity(1)
                .build();
    }

    public static BookDto createTestBookDtoA() {
        return BookDto.builder()
                .isbn("1234")
                .title("Book 1")
                .quantity(1L)
                .build();
    }

    public static BookEntity createTestBookB() {
        return BookEntity.builder()
                .isbn("2345")
                .title("Book 2")
                .quantity(1)
                .build();
    }

    public static OrderEntity createTestOrderA(BookEntity bookEntity, UserEntity userEntity) throws ParseException{


        return OrderEntity.builder()
                .id(1L)
                .bookEntity(bookEntity)
                .userEntity(userEntity)
                .issue_date(java.sql.Date.valueOf(LocalDate.of(2010,10,10)))
                .expiration_date(java.sql.Date.valueOf(LocalDate.of(2010,10,20)))
                .return_date(java.sql.Date.valueOf(LocalDate.of(2010,10,24)))
                .fine(10)
                .build();
    }

    public static OrderEntity createTestOrderB(BookEntity bookEntity, UserEntity userEntity) throws ParseException{
        return OrderEntity.builder()
                .id(2L)
                .bookEntity(bookEntity)
                .userEntity(userEntity)
                .issue_date(java.sql.Date.valueOf(LocalDate.of(2010,10,20)))
                .expiration_date(java.sql.Date.valueOf(LocalDate.of(2010,10,30)))
                .return_date(java.sql.Date.valueOf(LocalDate.of(2010,10,31)))
                .fine(20)
                .build();
    }

    public static UserEntity createTestUserA() {
        return UserEntity.builder()
                .id(1L)
                .name("user1")
                .age(20)
                .role("User")
                .build();
    }

    public static UserEntity createTestUserB() {
        return UserEntity.builder()
                .id(2L)
                .name("user2")
                .age(20)
                .role("User")
                .build();
    }
}
