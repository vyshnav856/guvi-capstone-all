package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Interaction;
import com.capstone.capstone_backend.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/interact")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @PostMapping
    public ResponseEntity<Object> createInteraction(@RequestBody Interaction interaction) {
        return ResponseEntity.ok(Objects.requireNonNullElse(interactionService.createInteraction(interaction), false));
    }

    @GetMapping
    public ResponseEntity<List<Interaction>> getAllInteractions() {
        List<Interaction> interactions = interactionService.getAllInteractions();
        return ResponseEntity.ok(interactions);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteInteraction(@PathVariable String id) {
        interactionService.deleteInteractionById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return response;
    }
}
