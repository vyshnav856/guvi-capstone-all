package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Follow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FollowRepository extends MongoRepository<Follow, String> {
    @Query(value = "{ 'follower': ?0, 'following': ?1 }", delete = true)
    void removeFollow(String follower, String following);
}
