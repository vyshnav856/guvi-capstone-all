package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.User;
import com.capstone.capstone_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            return "username";
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "password";
        }

        return "success";
    }

    public boolean signup(String username, String password, String role, String email, String bio, String picture) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            return false;
        }

        else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            user.setBio(bio);
            user.setEmail(email);
            user.setPicture(picture);
            userService.createUser(user);
            return true;
        }
    }
}
