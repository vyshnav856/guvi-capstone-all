package com.capstone.capstone_backend.repository;

import com.capstone.capstone_backend.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {}
