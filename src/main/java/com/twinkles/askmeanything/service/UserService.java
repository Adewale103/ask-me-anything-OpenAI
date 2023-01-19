package com.twinkles.askmeanything.service;

import com.twinkles.askmeanything.dto.request.AskQuestionResponse;
import com.twinkles.askmeanything.dto.request.RegisterRequest;
import com.twinkles.askmeanything.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
    AskQuestionResponse askQuestion(String question);
}
