package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Feed;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedRepository extends MongoRepository<Feed, String> {}

