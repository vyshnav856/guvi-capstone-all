package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private String username;
    private String postId;
    private String type;
    private String description;
    private boolean status;
}
