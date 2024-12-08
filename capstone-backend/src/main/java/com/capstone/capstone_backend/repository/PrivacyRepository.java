package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Privacy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrivacyRepository extends MongoRepository<Privacy, String> {}
