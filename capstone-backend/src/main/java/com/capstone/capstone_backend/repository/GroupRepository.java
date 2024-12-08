package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {}
