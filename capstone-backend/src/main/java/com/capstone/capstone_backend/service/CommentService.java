package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Comment;
import com.capstone.capstone_backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(String id) {
        return commentRepository.findById(id);
    }
}
