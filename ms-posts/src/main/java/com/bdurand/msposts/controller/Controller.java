package com.bdurand.msposts.controller;

import com.bdurand.msposts.domain.Post;
import com.bdurand.msposts.request.NewPostRequest;
import com.bdurand.msposts.request.UpdatePostRequest;
import com.bdurand.msposts.service.PostService;
import com.bdurand.msposts.service.ValidationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class Controller {

    @Autowired
    PostService postService;

    @Autowired
    ValidationService validationService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        log.info("Received request for all posts");
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        log.info("Received request: {}", id);
        return ResponseEntity.of(postService.getPost(id));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody NewPostRequest request) {
        log.info("Received request: {}", request);
        validationService.userExists(request.getUserId());
        Post newPost = postService.createPost(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.getId())
                .toUri();

        return ResponseEntity.created(uri).body(newPost);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @Valid @RequestBody UpdatePostRequest request) {
        log.info("Received request: {}", request);
        return ResponseEntity.ok(postService.updatePost(id, request));
    }
}
