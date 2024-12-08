package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Profile;
import com.capstone.capstone_backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<Profile>> getProfileByUserName(@PathVariable String username) {
        Optional<Profile> profile =  profileService.getProfileByUsername(username);

        if (profile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(profile);
        }
    }
}
