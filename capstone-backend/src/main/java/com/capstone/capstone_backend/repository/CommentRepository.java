package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
