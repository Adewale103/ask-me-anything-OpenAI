package com.twinkles.askmeanything.service;

import com.twinkles.askmeanything.dto.request.RegisterRequest;
import com.twinkles.askmeanything.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    private RegisterRequest registerRequest;


    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
        registerRequest = RegisterRequest.builder().build();
    }

    @Test
    public void userCanRegisterTest(){

    }
}