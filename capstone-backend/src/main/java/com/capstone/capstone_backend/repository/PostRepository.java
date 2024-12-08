package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {}
