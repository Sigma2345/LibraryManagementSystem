package com.assignment.LibraryManagementSystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Long id;
    private String book_id;
    private Long user_id;
    private Date issue_date;
    private Date expiration_date;
    private Date return_date;
    private Integer fine;
}
