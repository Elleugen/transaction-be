package com.example.transactions.controller;

import com.example.transactions.dto.AuthResponse;
import com.example.transactions.dto.AuthenticationRequest;
import com.example.transactions.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        return authService.authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());
    }
}
