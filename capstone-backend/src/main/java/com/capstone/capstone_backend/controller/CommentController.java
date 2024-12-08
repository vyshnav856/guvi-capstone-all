package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Comment;
import com.capstone.capstone_backend.model.Notification;
import com.capstone.capstone_backend.model.Post;
import com.capstone.capstone_backend.service.CommentService;
import com.capstone.capstone_backend.service.NotificationService;
import com.capstone.capstone_backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    PostService postService;

    @Autowired
    NotificationService notificationService;


    @PostMapping
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        Comment newComment = commentService.createComment(comment);
        postService.incrementComment(comment.getPostId());

        Notification notification = new Notification();
        Optional<Post> post = postService.getPostById(comment.getPostId());
        if (post.isPresent()) {
            notification.setUsername(post.get().getUsername());
            notification.setType("Comment");
            notification.setMessage(comment.getUsername() + " commented on your post " + post.get().getId());
            notification.setTimestamp(String.valueOf(LocalDateTime.now()));
            notificationService.createNotification(notification);
        }

        return ResponseEntity.ok(Objects.requireNonNullElse(newComment, false));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Comment>> getCommentById(@PathVariable String id) {
        Optional<Comment> comment =  commentService.getCommentById(id);

        if (comment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(comment);
        }
    }
}
