package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class PeopleController {

    String url = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/people")
    public ResponseEntity <String> getPeople(){
        return restTemplate.getForEntity(this.url, String.class);
    }
}
