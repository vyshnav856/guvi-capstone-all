package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Advert;
import com.capstone.capstone_backend.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AdvertService {
    @Autowired
    private AdvertRepository advertRepository;

    public Advert createAdvert(Advert advert) {
        return advertRepository.save(advert);
    }

    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }
}
