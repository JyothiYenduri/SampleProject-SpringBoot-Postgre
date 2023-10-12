package com.talentstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.RecommendedJob;
import com.talentstream.service.RecommendedJobsService;

@CrossOrigin("*")
@RestController
public class RecommendedJobsController {

	@Autowired

	private RecommendedJobsService recommendedJobsService;

	@GetMapping("/applicants/recommended-jobs/{id}")
    public ResponseEntity<List<RecommendedJob>> getRecommendedJobsForApplicant(
            @PathVariable int applicantId) {
        List<RecommendedJob> recommendedJobs = recommendedJobsService.getRecommendedJobsForApplicant(applicantId);
        return ResponseEntity.ok(recommendedJobs);
    }

	

	// recommended job for all applicant

	

//	 @GetMapping("applicants/allapplicants/recommended-jobs")
//
//	    public ResponseEntity<List<RecommendedJob>> getAllRecommendedJobs() {
//
//	        List<RecommendedJob> recommendedJobs = recommendedJobsService.getRecommendedJobsForAllApplicants();
//
//	        return ResponseEntity.ok(recommendedJobs);
//
//	    }

}
