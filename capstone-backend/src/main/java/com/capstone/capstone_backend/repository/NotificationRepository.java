package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {}
