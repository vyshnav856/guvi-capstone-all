package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {}
