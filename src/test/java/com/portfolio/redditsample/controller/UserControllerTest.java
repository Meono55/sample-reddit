package com.portfolio.redditsample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portfolio.redditsample.model.User;
import com.portfolio.redditsample.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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
    public void createUser_Successfully() throws Exception{

        User user = new User();
        user.setUsername("test");
        user.setPassword("pass");


        //given

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



}