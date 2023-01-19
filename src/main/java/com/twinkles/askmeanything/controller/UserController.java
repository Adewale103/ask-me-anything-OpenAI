package com.twinkles.askmeanything.controller;

import com.twinkles.askmeanything.dto.request.AskQuestionResponse;
import com.twinkles.askmeanything.dto.request.RegisterRequest;
import com.twinkles.askmeanything.dto.response.RegisterResponse;
import com.twinkles.askmeanything.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/askMe")
public class UserController {
    private final UserService userService;

   @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
       RegisterResponse registerResponse = userService.register(request);
       return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
   }

    @GetMapping("/question")
    public ResponseEntity<?> askQuestion(@RequestParam String question){
        AskQuestionResponse askQuestionResponse = userService.askQuestion(question);
        return new ResponseEntity<>(askQuestionResponse, HttpStatus.OK);
    }
}
