package com.assignment.LibraryManagementSystem.dao.impl;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserDaoImplIntegrationTests {

    private UserDaoImpl underTest;

    @Autowired
    public UserDaoImplIntegrationTests(UserDaoImpl underTest){this.underTest = underTest;}

    @Test
    public void testThatUserCreatedAndRecalled(){
        User user = TestDataUtil.createTestUser();
        underTest.create(user);
        Optional<User> result = underTest.findOne(user.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(user);
    }

}
