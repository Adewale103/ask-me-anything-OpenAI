package com.twinkles.askmeanything.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data {
    private String text;
    private int index;
    private String logprobs;
    private String finish_reason;
}
