package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Data
@Document(collection = "privacy")
public class Privacy {
    @Id
    private String id;
    private boolean postVisibility;
    private boolean profileVisibility;
    private List<String> blocked;
}
