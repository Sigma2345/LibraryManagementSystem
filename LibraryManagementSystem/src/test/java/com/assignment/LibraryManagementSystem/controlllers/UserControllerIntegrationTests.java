package com.assignment.LibraryManagementSystem.controlllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.assignment.LibraryManagementSystem.TestDataUtil;
import com.assignment.LibraryManagementSystem.domain.entities.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    public UserControllerIntegrationTests(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreateAdminReturnsHttpCode201() throws Exception {
        UserEntity adminEntity = TestDataUtil.createTestAdminA();
        adminEntity.setId(null);
        String adminJson = objectMapper.writeValueAsString(adminEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(adminJson))
                .andExpect(
                        MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testThatCreateAdminReturnsSavedAdmin() throws Exception {
        UserEntity adminEntity = TestDataUtil.createTestAdminA();
        adminEntity.setId(null);
        String adminJson = objectMapper.writeValueAsString(adminEntity);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(adminJson))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.name").value("admin1"))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.age").value(20));
    }

}
