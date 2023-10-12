package com.talentstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.Job;
import com.talentstream.service.ViewJobService;
@RestController
public class ViewJobController {
	@Autowired
    private ViewJobService viewJobService;

    @GetMapping("/applicant/{jobId}/viewjob")
    public ResponseEntity<Job> getJobDetails(@PathVariable Long jobId) {
        try {
            Job jobDetails = viewJobService.getJobDetails(jobId);
            return ResponseEntity.ok(jobDetails);
        } catch (Exception e) {
            // Handle the exception when the specified job ID does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
