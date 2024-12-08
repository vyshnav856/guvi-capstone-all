package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Advert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertRepository extends MongoRepository<Advert, String> {}
