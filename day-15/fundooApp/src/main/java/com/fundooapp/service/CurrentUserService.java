package com.fundooapp.service;

import com.fundooapp.entity.User;
import com.fundooapp.exception.ResourceNotFoundException;
import com.fundooapp.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {
    private final UserRepository users;
    public CurrentUserService(UserRepository users) { this.users = users; }
    public User get() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return users.findByEmail(principal.toString()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
