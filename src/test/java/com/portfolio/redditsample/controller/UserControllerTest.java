package com.portfolio.redditsample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portfolio.redditsample.model.User;
import com.portfolio.redditsample.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    private User newUser;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup(){
        newUser = new User();
        newUser.setPassword("password");
        newUser.setUsername("test");
        objectMapper.registerModule(new JavaTimeModule());

    }


    @Test
    public void createUser__should_get_status_created() throws Exception{

        User user = new User();
        user.setUsername("test");
        user.setPassword("pass");

        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/create-user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(user))
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(
                        status().isCreated());
    }

    @Test
    public void getAllUsers_should_get_Status_OK() throws Exception {

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("pass1");
        userList.add(user1);
        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("pass2");
        userList.add(user2);

        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders
        .get("/user/get-all")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(userList)));

    }

    @Test
    public void getUserById_should_get_Status_OK() throws Exception {

        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("pass1");

        when(userService.getUserById(any())).thenReturn(user1);

        mockMvc.perform(MockMvcRequestBuilders
        .get("/user/get-user/{id}", 1L)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
                .andExpect(
                status().isOk()).andExpect(MockMvcResultMatchers
                .content().string(objectMapper.writeValueAsString(user1)));
    }



}