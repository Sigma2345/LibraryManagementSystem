package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminDaoImplIntegrationTests {
    private final AdminDaoImpl underTest;

    @Autowired
    public AdminDaoImplIntegrationTests(AdminDaoImpl underTest){
        this.underTest = underTest;
    }
    @Test
    public void testThatAdminCanBeCreatedAndRecalled(){
        Admin admin = TestDataUtil.createTestAdminA();
        underTest.create(admin);
        Optional<Admin> result = underTest.findOne(admin.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(admin);
    }


    @Test
    public void testThatMultipleAdminCanBeCreatedAndRecalled(){
        Admin adminA = TestDataUtil.createTestAdminA();
        underTest.create(adminA);
        Admin adminB = TestDataUtil.createTestAdminB();
        underTest.create(adminB);
        Admin adminC = TestDataUtil.createTestAdminC();
        underTest.create(adminC);

        List<Admin> results = underTest.find();
        assertThat(results)
                .hasSize(3)
                .containsExactly(adminA, adminB, adminC);
    }
}
