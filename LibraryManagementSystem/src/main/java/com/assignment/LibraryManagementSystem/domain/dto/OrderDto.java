package com.assignment.LibraryManagementSystem.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private UserDto userDto;
    private BookDto bookDto;
    private java.sql.Date issue_date;
    private java.sql.Date expiration_date;
    private java.sql.Date return_Date;
    private Integer fine; 
}
