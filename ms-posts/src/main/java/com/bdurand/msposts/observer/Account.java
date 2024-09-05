package com.bdurand.msposts.observer;

import com.bdurand.msposts.domain.Post;

import java.util.ArrayList;
import java.util.List;

public class Account implements Observable{

    private String username;
    private List<Observer> followers;

    private Post lastPost;

    public Account(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
    }

    @Override
    public void attach(Observer o) {
        this.followers.add(o);
    }

    @Override
    public void detach(Observer o) {
        this.followers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer f: this.followers){
            f.update("The user " + this.username + " has posted: " + this.lastPost.getTitle());
        }
    }

    public void createPost(Post post) {
        this.lastPost = post;
    }
}
