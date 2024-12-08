package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String username;
    private String content;
    private String mediaUrl;
    private String mediaType;
    private String timestamp;
    private int likes = 0;
    private int commentsCount = 0;
}
