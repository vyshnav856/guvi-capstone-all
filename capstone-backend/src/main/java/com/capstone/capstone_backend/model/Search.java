package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "searches")
public class Search {
    @Id
    private String id;
    private String username;
    private String query;
    private String timestamp;
}
