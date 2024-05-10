package com.bdurand.msposts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidationService {

    @Autowired
    RestTemplate restTemplate;

    public Boolean validateUserExists(Integer userId) {

        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);
        return true;
    }
}
