package com.twinkles.askmeanything.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gpt3Request {
    private String prompt;
    private int maxTokens;
    private String stop;
}
