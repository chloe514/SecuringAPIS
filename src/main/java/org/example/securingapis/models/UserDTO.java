package org.example.securingapis.models;

import java.util.Set;

public class UserDTO {
    private String username;
    private String password;
    private Set<String> roles; // Define roles here

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    // Convert UserDTO to User entity
    public User toUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRoles(this.roles); // Ensure this line correctly sets the roles
        return user;
    }
}



