package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Search, String> {}
