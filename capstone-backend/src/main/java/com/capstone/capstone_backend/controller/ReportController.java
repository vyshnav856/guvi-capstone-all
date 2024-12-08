package com.capstone.capstone_backend.controller;

import com.capstone.capstone_backend.model.Report;
import com.capstone.capstone_backend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<Object> createReport(@RequestBody Report report) {
        Report newReport = reportService.createReport(report);
        return ResponseEntity.ok(Objects.requireNonNullElse(newReport, false));
    }

    @GetMapping
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Report>> getReportById(@PathVariable String id) {
        Optional<Report> report =  reportService.getReportById(id);

        if (report.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        else {
            return ResponseEntity.ok(report);
        }
    }
}
