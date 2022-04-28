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
                filter(i-> {
                    if(i instanceof Number) return true;

                    if(i instanceof String) {
                        String x = (String)i;

                        try {
                            Integer.parseInt(x);
                            return true;
                        } catch(Exception e) {
                            return false;
                        }

                    }
                    return false;
                }).
                map(i-> {
                    if(i instanceof Number) {
                        return (Integer)i;
                    } else {
                        return Integer.parseInt(i.toString());
                    }
                }).
                collect(Collectors.toList());

        //Exracting Characters from the given array
        List<Character> alphabets = input.stream().
                filter(i-> {

                    //if number
                    if(i instanceof Number) return false;

                    //if string
                    if(i instanceof String) {
                        String x = (String)i;

                        try {
                            Integer.parseInt(x);

                            return false;
                        } catch(Exception e) {
                            return true;
                        }

                    }
                    return false;
                }).
                map(i-> ((String) i).charAt(0)).
                collect(Collectors.toList());

        //Creating our response object
        response.setIs_success(true);
        response.setUserId("sonal_kamble_24091999");
        response.setEmailId("kamblesonal893@gmail.com");
        response.setRollNumber("PD0412");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);

        return response;
    }
}
