package com.kamble.bajaj.service;

import com.kamble.bajaj.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArrayServiceImpl implements  ArrayService{

    @Override
    public Response getResponse(List<Object> input) {

        Response response = new Response();

        //Extracting Numbers from the given array
        List<Integer> numbers = input.stream().
                filter(i-> i instanceof Number).
                map(i-> (Integer)i).
                collect(Collectors.toList());

        //Exracting Characters from the given array
        List<Character> alphabets = input.stream().
                filter(i-> i instanceof String).
                map(i->  ((String) i).charAt(0)).
                collect(Collectors.toList());

        //Creating our response object
        response.setStatus(true);
        response.setUserId("sonal_kamble_24091999");
        response.setEmailId("kamblesonal893@gmail.com");
        response.setRollNumber("PD0412");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);

        return response;
    }
}
