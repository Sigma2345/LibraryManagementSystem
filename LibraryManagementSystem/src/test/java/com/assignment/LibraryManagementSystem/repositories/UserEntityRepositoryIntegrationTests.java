package com.assignment.LibraryManagementSystem.repositories;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserEntityRepositoryIntegrationTests {

    private final UserRepository underTest;

    @Autowired
    public UserEntityRepositoryIntegrationTests(UserRepository underTest){this.underTest = underTest;}

    @Test
    public void testThatUserCreatedAndRecalled(){
        UserEntity userEntity = TestDataUtil.createTestUserA();
        underTest.save(userEntity);
        Optional<UserEntity> result = underTest.findById(userEntity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntity);
    }

//    @Test
//    public void testThatMultipleUsersCanBeCreatedAndRecalled(){
//        User userA = TestDataUtil.createTestUserA();
//        underTest.create(userA);
//        User userB = TestDataUtil.createTestUserB();
//        underTest.create(userB);
//
//        List<User> results = underTest.find();
//        assertThat(results).hasSize(2).containsExactly(userA, userB);
//    }
//
//    @Test
//    public void testThatUserCanBeUpdatedAndRecalled(){
//        User userA = TestDataUtil.createTestUserA();
//        underTest.create(userA);
//        userA.setName("name 2");
//        underTest.update(userA.getId(), userA);
//        Optional<User> result = underTest.findOne(userA.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(userA);
//    }
//
//    @Test
//    public void testThatUserCanBeDeleted(){
//        User userA = TestDataUtil.createTestUserA();
//        underTest.create(userA);
//        underTest.delete(userA.getId());
//        Optional<User> result = underTest.findOne(userA.getId());
//        assertThat(result).isEmpty();
//    }
}
