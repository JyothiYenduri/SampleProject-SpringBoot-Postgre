package com.talentstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.service.SavedJobService;

@RestController
public class SavedJobController {
	 @Autowired
	    private SavedJobService savedJobService;

	    @PostMapping("/applicants/job/{applicantId}/{jobId}")
	    public String saveJobForApplicant(
	            @PathVariable long applicantId,
	            @PathVariable long jobId
	    ) {
	        try {
	            savedJobService.saveJobForApplicant(applicantId, jobId);
	            return "Job saved successfully for the applicant.";
	        } catch (Exception e) {
	            return "Unable to save the job for the applicant.";
	        }
}
}
