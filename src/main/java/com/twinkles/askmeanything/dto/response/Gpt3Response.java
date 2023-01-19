package com.twinkles.askmeanything.dto.response;

import com.twinkles.askmeanything.dto.Data;
import com.twinkles.askmeanything.dto.Timing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gpt3Response {
    private String id;
    private String engine;
    private String prompt;
    private List<Data> choices;
    private String model;
    private Timing timing;
}
