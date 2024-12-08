package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Interaction;
import com.capstone.capstone_backend.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InteractionService {
    @Autowired
    private InteractionRepository interactionRepository;

    public Interaction createInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    public   List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    public void deleteInteractionById(String id) {
        interactionRepository.deleteById(id);
    }

    public void deleteInteraction(String username, String postId) {
        interactionRepository.deleteByUsernameAndPostId(username, postId);
    }
}
