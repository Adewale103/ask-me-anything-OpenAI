package com.twinkles.askmeanything.dto.response;

import com.twinkles.askmeanything.model.Data;
import com.twinkles.askmeanything.model.Usage;
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
    private String object;
    private int created;
    private String model;
    private List<Data> choices;
    private Usage usage;
}
