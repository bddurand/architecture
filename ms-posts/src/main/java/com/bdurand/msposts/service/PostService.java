package com.bdurand.msposts.service;

import com.bdurand.msposts.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    @Autowired
    RestTemplate restTemplate;

    public Post createPost() {

        return new Post();
    }
}
