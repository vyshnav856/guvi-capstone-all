package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Search;
import com.capstone.capstone_backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/searches")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @PostMapping
    public ResponseEntity<Object> createSearch(@RequestBody Search search) {
        Search newSearch = searchService.createSearch(search);
        return ResponseEntity.ok(Objects.requireNonNullElse(newSearch, false));
    }

    @GetMapping
    public ResponseEntity<List<Search>> getAllSearches() {
        List<Search> searches = searchService.getAllSearches();
        return ResponseEntity.ok(searches);
    }
}
