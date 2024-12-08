package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.User;
import com.capstone.capstone_backend.model.Profile;
import com.capstone.capstone_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileService profileService;

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Profile newProfile = new Profile();
        newProfile.setBio(user.getBio());
        newProfile.setUsername(user.getUsername());
        newProfile.setContact(user.getEmail());
        newProfile.setPicture(user.getPicture());
        profileService.createProfile(newProfile);
        user.setActive(true);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
