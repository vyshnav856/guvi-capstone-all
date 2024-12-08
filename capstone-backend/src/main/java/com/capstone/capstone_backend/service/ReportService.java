package com.capstone.capstone_backend.service;

import com.capstone.capstone_backend.model.Report;
import com.capstone.capstone_backend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(String id) {
        return reportRepository.findById(id);
    }
}
