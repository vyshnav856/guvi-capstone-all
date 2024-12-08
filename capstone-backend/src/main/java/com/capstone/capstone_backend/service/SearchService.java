package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Search;
import com.capstone.capstone_backend.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public Search createSearch(Search search) {
        return searchRepository.save(search);
    }

    public List<Search> getAllSearches() {
        return searchRepository.findAll();
    }
}
