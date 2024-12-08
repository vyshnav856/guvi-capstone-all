package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Post;
import com.capstone.capstone_backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    NotificationService notificationService;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(String id) {
        return postRepository.findById(id);
    }

    public void likePost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post actual = post.get();
            actual.setLikes(actual.getLikes() + 1);
            postRepository.save(actual);
        }


    }

    public void unlikePost(String id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isPresent()) {
            Post actual = post.get();
            actual.setLikes(actual.getLikes() - 1);
            postRepository.save(actual);
        }
    }

    public void incrementComment(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post actual = post.get();
            actual.setCommentsCount(actual.getCommentsCount() + 1);
            postRepository.save(actual);
        }
    }
}
