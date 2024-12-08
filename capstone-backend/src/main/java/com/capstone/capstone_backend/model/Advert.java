package com.capstone.capstone_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "adverts")
public class Advert {
    @Id
    private String id;
    private String url;
    private String content;
    private String link;
}
