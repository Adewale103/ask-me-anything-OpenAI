package com.twinkles.askmeanything.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private String text;
    private int index;
    private String logprobs;
    private String stop;
    private int score;
}
