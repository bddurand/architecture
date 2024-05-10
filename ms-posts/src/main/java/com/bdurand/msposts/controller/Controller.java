package com.bdurand.msposts.controller;

import com.bdurand.msposts.request.NewPostRequest;
import com.bdurand.msposts.service.PostService;
import com.bdurand.msposts.service.ValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    ValidationService validationService;

    @PostMapping("/posts")
    public String createPost(@Valid @RequestBody NewPostRequest request) {
        //validate if user exists
        validationService.validateUserExists(request.getUserId());
        //Save post

        //return response
        return "Post created successfully!";
    }
}
