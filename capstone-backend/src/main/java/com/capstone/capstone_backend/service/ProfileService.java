package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Profile;
import com.capstone.capstone_backend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;


    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileByUsername(String username) {
        return profileRepository.findByUsername(username);
    }
}
