package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Interaction;
import com.capstone.capstone_backend.model.Notification;
import com.capstone.capstone_backend.model.Post;
import com.capstone.capstone_backend.service.InteractionService;
import com.capstone.capstone_backend.service.NotificationService;
import com.capstone.capstone_backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private InteractionService interactionService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return ResponseEntity.ok(Objects.requireNonNullElse(newPost, false));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable String id) {
        Optional<Post> post =  postService.getPostById(id);

        if (post.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(post);
        }
    }

    @PostMapping("/like/{id}")
    public String likePost(@PathVariable String id, @RequestBody Map<String, String> request) {
        postService.likePost(id);
        String username = request.get("username");
        String postId = request.get("postId");
        Interaction interaction = new Interaction();
        interaction.setUsername(username);
        interaction.setPostId(postId);
        interactionService.createInteraction(interaction);

        Notification notification = new Notification();
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            notification.setUsername(post.get().getUsername());
            notification.setType("Like");
            notification.setMessage(username + " liked your post " + post.get().getId());
            notification.setTimestamp(String.valueOf(LocalDateTime.now()));
            notificationService.createNotification(notification);
        }
        return "post liked";
    }

    @PostMapping("/unlike/{id}")
    public String unlikePost(@PathVariable String id, @RequestBody Map<String, String> request) {
        postService.unlikePost(id);
        String username = request.get("username");
        String postId = request.get("postId");
        interactionService.deleteInteraction(username, postId);
        return "post unliked";
    }
}
