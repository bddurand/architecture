package com.bdurand.msposts.observer;

public class Follower implements Observer{

    private String name;

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Nueva notificacion recibida: " + message);
    }
}
