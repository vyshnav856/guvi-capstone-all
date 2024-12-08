package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Feed;
import com.capstone.capstone_backend.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FeedService {
    @Autowired
    private FeedRepository feedRepository;

    public Feed createFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    public List<Feed> getAllFeeds() {
        return feedRepository.findAll();
    }

    public Optional<Feed> getFeedById(String id) {
        return feedRepository.findById(id);
    }
}
