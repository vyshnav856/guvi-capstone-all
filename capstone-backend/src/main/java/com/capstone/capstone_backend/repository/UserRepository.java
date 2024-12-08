package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
