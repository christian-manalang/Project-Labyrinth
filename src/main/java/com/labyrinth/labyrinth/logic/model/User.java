package com.labyrinth.labyrinth.logic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private String role;
    private String fullName;
    private String lastLogin;

    public boolean isAdmin() {
        return "ADMIN".equalsIgnoreCase(this.role);
    }
}