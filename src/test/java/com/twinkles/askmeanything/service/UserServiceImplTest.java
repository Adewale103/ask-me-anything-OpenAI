package com.twinkles.askmeanything.service;

import com.twinkles.askmeanything.dto.request.RegisterRequest;
import com.twinkles.askmeanything.dto.response.RegisterResponse;
import com.twinkles.askmeanything.model.User;
import com.twinkles.askmeanything.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    private RegisterRequest registerRequest;
    private  User user;


    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
        registerRequest = RegisterRequest.builder()
                .email("james@gmail.com")
                .firstName("James")
                .lastName("Fred")
                .password("Nananaaa")
                .build();
       user = User.builder()
                .id("1")
                .email("james@gmail.com")
                .firstName("James")
                .lastName("Fred")
                .password("Nananaaa")
                .build();
    }

    @Test
    public void userCanRegisterTest(){
        when(userRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);
        RegisterResponse registerResponse = userService.register(registerRequest);
        assertThat(registerResponse.getEmail()).isEqualTo("james@gmail.com");
    }
}