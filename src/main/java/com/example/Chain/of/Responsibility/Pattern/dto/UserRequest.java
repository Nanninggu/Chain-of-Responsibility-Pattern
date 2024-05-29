package com.example.Chain.of.Responsibility.Pattern.dto;

public class UserRequest {
    // Example fields, adjust according to actual requirements
    private String username;
    private String email;
    private String password;

    // Constructor
    public UserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to convert UserRequest to User entity before persistence
    public User toUser() {
        // Assuming User is a domain entity class with username, email, and password fields
        return new User(this.username, this.email, this.password);
    }

}
