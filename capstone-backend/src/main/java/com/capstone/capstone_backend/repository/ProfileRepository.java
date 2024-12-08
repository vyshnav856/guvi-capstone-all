package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Profile;
import com.capstone.capstone_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, String> {
    Optional<Profile> findByUsername(String username);
}
