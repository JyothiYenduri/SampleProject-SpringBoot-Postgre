package com.talentstream.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.ApplyJob;
import com.talentstream.entity.Job;
import com.talentstream.repository.ApplicantProfileRepository;
import com.talentstream.repository.JobRepository;
import com.talentstream.service.ApplyJobService;

@RestController
public class ApplyJobController {
	 @Autowired
	    private ApplyJobService applyJobService;
	 
	 @Autowired
	 private ApplicantProfileRepository applicantProfileRepository;
	 
	 @Autowired
	 private JobRepository jobRepository;

	    @PostMapping("/applicant/applyjob")
	    public String applyForJob(@RequestParam long applicantId, @RequestParam long jobId) {
	      Optional<ApplicantProfile> applicant =  applicantProfileRepository.findById((int) applicantId);
	       Optional<Job> job = jobRepository.findById(jobId) ;

	        if (applicant.isEmpty() || job.isEmpty()) {
	            return "Invalid applicant or job.";
	        }

	        ApplyJob applyJob = applyJobService.applyForJob(applicant, job);
	        return"Job application submitted with ID: " + applyJob.getId();
	    }
	    
	    
	    
}
