package com.example.transactions.controller;

import com.example.transactions.model.Users;
import com.example.transactions.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public Users registerUsers(@RequestBody Users users) {
        return usersService.saveUser(users);
    }

//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        userService.registerUser(user);
//        return ResponseEntity.ok("User registered successfully");
//    }

//    @PostMapping("/verify")
//    public String verifyUser(@RequestBody Users users, @RequestParam String otpCode) {
//        usersService.verifyUser(users, otpCode);
//        return "User verified successfully";
//    }
}
