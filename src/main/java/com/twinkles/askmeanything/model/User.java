package com.twinkles.askmeanything.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
@Validated
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private RoleType roleType;
    private boolean verified;
    @CreatedDate
    private LocalDate dateJoined;
}
