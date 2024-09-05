package com.bdurand.msposts.service.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String id) {
        super("Post not found with id - " + id);
    }
}
