package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String sender;
    private String receiver;
    private String content;
    private String timestamp;
}
