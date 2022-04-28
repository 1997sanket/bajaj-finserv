package com.kamble.bajaj.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Response {

    private Boolean status;
    private String userId;
    private String emailId;
    private String rollNumber;
    private List<Integer> numbers;
    private List<Character> alphabets;

}
