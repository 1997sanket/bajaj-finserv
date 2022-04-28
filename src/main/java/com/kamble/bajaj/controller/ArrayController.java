package com.kamble.bajaj.controller;

import com.kamble.bajaj.model.RequestDTO;
import com.kamble.bajaj.model.Response;
import com.kamble.bajaj.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    //To test the application
    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    //Required endpoint
    @PostMapping("/")
    public Response create(@RequestBody List<Object> input) {

        Response response = arrayService.getResponse(input);

        return response;
    }

    @PostMapping("/bfhl")
    public Response create(@RequestBody RequestDTO requestDTO) {

        Response response = null;
        System.out.println("request dto : " + requestDTO);

        try {
            response = arrayService.getResponse(requestDTO.getData());
        } catch (Exception e) {
            response = new Response();

            //Creating our response object
            response.setIs_success(false);
            response.setUserId("sonal_kamble_24091999");
            response.setEmailId("kamblesonal893@gmail.com");
            response.setRollNumber("PD0412");
            response.setNumbers(Collections.emptyList());
            response.setAlphabets(Collections.emptyList());
        }

        return response;
    }
}
