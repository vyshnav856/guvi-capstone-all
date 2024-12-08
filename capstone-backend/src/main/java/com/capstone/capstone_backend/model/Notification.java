package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String username;
    private String type;
    private String message;
    private boolean readStatus;
    private String timestamp;
}
