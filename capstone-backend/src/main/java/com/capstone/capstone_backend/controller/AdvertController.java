package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Advert;
import com.capstone.capstone_backend.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/adverts")
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    @PostMapping
    public ResponseEntity<Object> createAdvert(@RequestBody Advert advert) {
        return ResponseEntity.ok(Objects.requireNonNullElse(advertService.createAdvert(advert), false));
    }

    @GetMapping
    public ResponseEntity<List<Advert>> getAllAdverts() {
        List<Advert> adverts = advertService.getAllAdverts();
        return ResponseEntity.ok(adverts);
    }
}
