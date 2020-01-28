package com.finance.demo.model;

import java.util.UUID;

public class User {

    private final String username;
    private final UUID id;

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}