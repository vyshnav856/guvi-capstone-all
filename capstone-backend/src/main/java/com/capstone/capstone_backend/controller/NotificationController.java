package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Notification;
import com.capstone.capstone_backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Object> createNotification(@RequestBody Notification notification) {
        Notification newNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(Objects.requireNonNullElse(newNotification, false));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Notification>> getNotificationById(@PathVariable String id) {
        Optional<Notification> notification =  notificationService.getNotificationById(id);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(notification);
        }
    }
}
