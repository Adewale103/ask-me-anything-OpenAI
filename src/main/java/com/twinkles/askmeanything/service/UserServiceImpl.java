package com.twinkles.askmeanything.service;

import com.twinkles.askmeanything.dto.request.AskQuestionResponse;
import com.twinkles.askmeanything.dto.request.RegisterRequest;
import com.twinkles.askmeanything.dto.response.RegisterResponse;
import com.twinkles.askmeanything.exception.AskMeAnyThingException;
import com.twinkles.askmeanything.model.User;
import com.twinkles.askmeanything.repository.UserRepository;
import com.twinkles.askmeanything.utils.GPT3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        Optional<User> optionUser = userRepository.findByEmail(registerRequest.getEmail());
        if(optionUser.isPresent()){
            throw new AskMeAnyThingException("user with email already exist");
        }
        String username = generateUsernameFor(registerRequest);
        User user = new User();
        BeanUtils.copyProperties(registerRequest, user);
        User savedUser = userRepository.save(user);
        return RegisterResponse.builder()
                .id(savedUser.getId())
                .username(username)
                .email(savedUser.getEmail())
                .build();

    }

    @Override
    public AskQuestionResponse askQuestion(String question) {
      String response = GPT3Service.generateText(question);
      return AskQuestionResponse.builder().question(question).response(response).build();
    }

    private String generateUsernameFor(RegisterRequest registerRequest) {
        String username = registerRequest.getFirstName() +"-"+UUID.randomUUID().toString().substring(0,5).toUpperCase();
        if(userRepository.existsByUsername(username)){
            generateUsernameFor(registerRequest);
        }
        return username;
    }
}
