package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Follow;
import com.capstone.capstone_backend.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    public Optional<Follow> getFollowById(String id) {
        return followRepository.findById(id);
    }

    public void deleteFollowById(String id) {
        followRepository.deleteById(id);
    }

    public void deleteFollow(String follower, String following) {
        followRepository.removeFollow(follower, following);
    }
}
