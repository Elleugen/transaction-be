package com.example.transactions.service;

import com.example.transactions.dto.AuthResponse;
import com.example.transactions.model.Users;
import com.example.transactions.repository.UsersRepository;
import com.example.transactions.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsersRepository usersRepository;

    public AuthResponse authenticate(String userId, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
        } catch (Exception e) {
            throw new Exception("Invalid userId or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        Users users = usersRepository.findByUserId(userId).orElseThrow(() -> new Exception("User not found"));

        return new AuthResponse(
                jwt,
                users.getCorporateAccountNo(),
                users.getCorporateName(),
                users.getUserId(),
                users.getUserName(),
                users.getRole(),
                users.getPhoneNo(),
                users.getEmail()
        );
    }
}
