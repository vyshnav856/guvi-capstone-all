package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "profiles")
public class Profile {
    @Id
    private String id;
    private String username;
    private String picture;
    private String bio;
    private String contact;
}
