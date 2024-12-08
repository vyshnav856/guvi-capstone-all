package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Follow;
import com.capstone.capstone_backend.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @PostMapping
    public ResponseEntity<Object> createFollow(@RequestBody Follow follow) {
        Follow newFollow = followService.createFollow(follow);
        return ResponseEntity.ok(Objects.requireNonNullElse(newFollow, false));
    }

    @PostMapping("/unfollow")
    public ResponseEntity<Object> unfollow(@RequestBody Map<String, String> request) {
        followService.deleteFollow(request.get("follower"), request.get("following"));
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<Follow>> getAllFollows() {
        List<Follow> follows = followService.getAllFollows();
        return ResponseEntity.ok(follows);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteFollow(@PathVariable String id) {
        followService.deleteFollowById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return response;
    }
}
