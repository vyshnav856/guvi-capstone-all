package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Privacy;
import com.capstone.capstone_backend.service.PrivacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/privacy")
public class PrivacyController {
    @Autowired
    private PrivacyService privacyService;

    @PostMapping
    public ResponseEntity<Object> createPrivacy(@RequestBody Privacy privacy) {
        Privacy newPrivacy = privacyService.createPrivacy(privacy);
        return ResponseEntity.ok(Objects.requireNonNullElse(newPrivacy, false));
    }

    @GetMapping
    public ResponseEntity<List<Privacy>> getAllPrivacy() {
        List<Privacy> privacy = privacyService.getAllPrivacy();
        return ResponseEntity.ok(privacy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Privacy>> getPrivacyById(@PathVariable String id) {
        Optional<Privacy> privacy =  privacyService.getPrivacyById(id);

        if (privacy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(privacy);
        }
    }
}
