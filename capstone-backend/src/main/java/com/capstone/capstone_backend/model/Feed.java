package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Data
@Document(collection = "feeds")
public class Feed {
    @Id
    private String id;
    private String username;
    private List<String> posts;
}
