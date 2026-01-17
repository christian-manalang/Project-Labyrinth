package com.labyrinth.labyrinth.logic.service;

import com.labyrinth.labyrinth.logic.model.User;

public class AuthService {

    // temp, replace once db is up
    public User login(String username, String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            String role = username.toLowerCase().contains("admin") ? "ADMIN" : "STAFF";
            return new User(username, "dummyPass", role, "Test User", null);
        }
        return null;
    }
}