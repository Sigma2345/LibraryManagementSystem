package com.assignment.LibraryManagementSystem.repositories;

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
public class AdminRepositoryIntegrationTests {
    private final AdminRepository underTest;

    @Autowired
    public AdminRepositoryIntegrationTests(AdminRepository underTest){
        this.underTest = underTest;
    }
    @Test
    public void testThatAdminCanBeCreatedAndRecalled(){
        Admin admin = TestDataUtil.createTestAdminA();
        underTest.save(admin);
        Optional<Admin> result = underTest.findById(admin.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(admin);
    }


//    @Test
//    public void testThatMultipleAdminCanBeCreatedAndRecalled(){
//        Admin adminA = TestDataUtil.createTestAdminA();
//        underTest.create(adminA);
//        Admin adminB = TestDataUtil.createTestAdminB();
//        underTest.create(adminB);
//        Admin adminC = TestDataUtil.createTestAdminC();
//        underTest.create(adminC);
//
//        List<Admin> results = underTest.find();
//        assertThat(results)
//                .hasSize(3)
//                .containsExactly(adminA, adminB, adminC);
//    }
//
//    @Test
//    public void testThatAdminCanBeUpdatedAndRecalled(){
//        Admin adminA = TestDataUtil.createTestAdminA();
//        underTest.create(adminA);
//        adminA.setName("adminA new name");
//        underTest.update(adminA.getId(), adminA);
//        Optional<Admin> result = underTest.findOne(adminA.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(adminA);
//    }
//
//    @Test
//    public void testThatAdminCanBeDeleted(){
//        Admin adminA = TestDataUtil.createTestAdminA();
//        underTest.create(adminA);
//        underTest.delete(adminA.getId());
//        Optional<Admin> result = underTest.findOne(adminA.getId());
//        assertThat(result).isEmpty();
//    }
}
