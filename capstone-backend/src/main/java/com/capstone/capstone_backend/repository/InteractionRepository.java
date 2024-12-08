package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Interaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InteractionRepository extends MongoRepository<Interaction, String> {
    void deleteByUsernameAndPostId(String username, String postId);
}
