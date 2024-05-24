package com.bdurand.msposts.controller;

import com.bdurand.msposts.request.NewPostRequest;
import com.bdurand.msposts.service.PostService;
import com.bdurand.msposts.service.ValidationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    ValidationService validationService;

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@Valid @RequestBody NewPostRequest request) {

        log.info("Received request: {}", request);
        validationService.userExists(request.getUserId());
        return ResponseEntity.ok("Post created successfully");
    }
}
