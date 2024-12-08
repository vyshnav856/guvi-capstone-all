package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.service.AuthService;
import com.capstone.capstone_backend.service.UserService;
import com.capstone.capstone_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        String success = authService.login(username, password);

        HashMap<String, Object> response = new HashMap<>();
        if (success.equals("username")) {
            response.put("success", false);
            response.put("message", "username invalid");
        }

        else if (success.equals("password")) {
            response.put("success", false);
            response.put("message", "password invalid");
        }

        else {
            response.put("success", true);
            response.put("message", "password valid");
            Optional<User> user = userService.getUserByUsername(username);
            if (user.isPresent()) {
                response.put("role", user.get().getRole());
                response.put("username", user.get().getUsername());
                response.put("userId", user.get().getId());
                response.put("picture", user.get().getPicture());
            }
        }

        return response;
    }

    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        String role = credentials.get("role");
        String email = credentials.get("email");
        String bio = credentials.get("bio");
        String picture = credentials.get("picture");
        boolean success = authService.signup(username, password, role, email, bio, picture);

        HashMap<String, Object> response = new HashMap<>();
        if (success) {
            response.put("success", true);
            response.put("message", "user successfully created");
        }

        else {
            response.put("success", false);
            response.put("message", "username already exists");
        }

        return response;
    }
}
