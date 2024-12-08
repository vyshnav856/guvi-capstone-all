package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Privacy;
import com.capstone.capstone_backend.repository.PrivacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PrivacyService {
    @Autowired
    private PrivacyRepository privacyRepository;

    public Privacy createPrivacy(Privacy privacy) {
        return privacyRepository.save(privacy);
    }

    public List<Privacy> getAllPrivacy() {
        return privacyRepository.findAll();
    }

    public Optional<Privacy> getPrivacyById(String id) {
        return privacyRepository.findById(id);
    }
}
