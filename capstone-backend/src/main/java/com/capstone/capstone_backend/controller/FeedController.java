package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Feed;
import com.capstone.capstone_backend.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {
    @Autowired
    private FeedService feedService;

    @PostMapping
    public ResponseEntity<Object> createFeed(@RequestBody Feed feed) {
        Feed newFeed = feedService.createFeed(feed);
        return ResponseEntity.ok(Objects.requireNonNullElse(newFeed, false));
    }

    @GetMapping
    public ResponseEntity<List<Feed>> getAllFeeds() {
        List<Feed> feeds = feedService.getAllFeeds();
        return ResponseEntity.ok(feeds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Feed>> getFeedById(@PathVariable String id) {
        Optional<Feed> feed =  feedService.getFeedById(id);

        if (feed.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(feed);
        }
    }
}
