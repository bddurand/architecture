package com.bdurand.msposts.service;

import com.bdurand.msposts.domain.Post;
import com.bdurand.msposts.observer.Account;
import com.bdurand.msposts.observer.Follower;
import com.bdurand.msposts.repository.PostRepository;
import com.bdurand.msposts.request.NewPostRequest;
import com.bdurand.msposts.request.UpdatePostRequest;
import com.bdurand.msposts.service.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Optional<Post> getPost(String id) {
        return postRepository.findById(id);
    }

    public Post createPost(NewPostRequest request) {

        Post p = new Post.Builder()
                    .userId(request.getUserId())
                    .title(request.getTitle())
                    .body(request.getBody())
                    .createdAt(LocalDateTime.now())
                    .build();

        postRepository.insert(p);

        //call notification service
        /*
        Account a = new Account("bdurand");
        Follower f1 = new Follower("nami");
        Follower f2 = new Follower("sanji");
        Follower f3 = new Follower("luffy");

        a.attach(f1);
        a.attach(f2);
        a.attach(f3);

        a.createPost(p);
        a.notifyObserver();
         */
        return p;
    }

    public Post updatePost(String id, UpdatePostRequest request) {

        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));

        if (request.getTitle() != null) {
            post.setTitle(request.getTitle());
        }
        if (request.getBody() != null) {
            post.setBody(request.getBody());
        }

        return postRepository.save(post);
    }
}
