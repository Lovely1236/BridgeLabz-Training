package com.fundooapp.service;

import com.fundooapp.dto.*;
import com.fundooapp.entity.User;
import com.fundooapp.exception.ConflictException;
import com.fundooapp.repository.UserRepository;
import com.fundooapp.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthService(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
        this.users = users; this.encoder = encoder; this.jwt = jwt;
    }

    public AuthResponse register(RegisterRequest request) {
        String email = request.email().trim().toLowerCase();
        if (users.existsByEmail(email)) throw new ConflictException("Email is already registered");
        User user = new User();
        user.setFirstName(request.firstName().trim()); user.setLastName(request.lastName().trim());
        user.setEmail(email); user.setPasswordHash(encoder.encode(request.password()));
        users.save(user);
        return response(email);
    }

    public AuthResponse login(LoginRequest request) {
        String email = request.email().trim().toLowerCase();
        User user = users.findByEmail(email).orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
        if (!encoder.matches(request.password(), user.getPasswordHash())) throw new BadCredentialsException("Invalid credentials");
        return response(email);
    }

    private AuthResponse response(String email) { return new AuthResponse(jwt.generate(email), email); }
}
