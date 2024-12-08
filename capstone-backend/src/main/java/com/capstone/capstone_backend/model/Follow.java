package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "following")
public class Follow {
    @Id
    private String id;
    private String follower;
    private String following;
}
