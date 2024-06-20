package com.example.transactions.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthenticationRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    // Default constructor
    public AuthenticationRequest() {
    }

    // Parameterized constructor
    public AuthenticationRequest(@NotBlank String userId, @NotBlank String password) {
        this.userId = userId;
        this.password = password;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
