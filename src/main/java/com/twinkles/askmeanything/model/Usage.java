package com.twinkles.askmeanything.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
}
