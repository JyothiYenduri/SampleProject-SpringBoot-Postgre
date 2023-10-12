package com.talentstream.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.Eligibility;
import com.talentstream.entity.Job;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.repository.JobRecruiterRepository;
import com.talentstream.repository.JobRepository;
import com.talentstream.service.EligibilityService;
import com.talentstream.service.JobRecruiterService;
import com.talentstream.service.JobService;

@RestController
public class JobController {
    private final JobService jobService;
    @Autowired
     JobRecruiterRepository jobRecruiterRepository;
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
//        this.eligibilityService = eligibilityService;
//        this.recruiterService=recruiterService;
    }

//    @PostMapping("/saveJob")
//    public ResponseEntity<String> saveJob(@RequestBody @Valid Job job) {
//         // Associate eligibility with the job
//    	JobRecruiter jobRecruiter = jobRecruiterRepository.findByrecruiterId(job.getJobRecruiter().getRecruiterId());
//
//        if (jobRecruiter != null) {
//            // Associate the JobRecruiter with the CompanyProfile
//            job.setJobRecruiter(jobRecruiter);
//            // Save the CompanyProfile with the associated JobRecruiter
//            jobService.saveJob(job);
//            return ResponseEntity.status(HttpStatus.OK).body("Job saved successfully.");
//        } else {
//            // Handle the case where the JobRecruiter with the provided ID does not exist
//            // You can return an error response with a 404 Not Found status code
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + job.getJobRecruiter().getRecruiterId() + " not found.");
//        }
//        
//        
//    }
    
    @PostMapping("/recruiters/saveJob/{jobRecruiterId}")
    public ResponseEntity<String> saveJob(@RequestBody @Valid Job job, @PathVariable Long jobRecruiterId) {
        // Associate eligibility with the job
        JobRecruiter jobRecruiter = jobRecruiterRepository.findByRecruiterId(jobRecruiterId);

        if (jobRecruiter != null) {
            // Associate the JobRecruiter with the CompanyProfile
            job.setJobRecruiter(jobRecruiter);
            // Save the CompanyProfile with the associated JobRecruiter
            jobService.saveJob(job);
            return ResponseEntity.status(HttpStatus.OK).body("Job saved successfully.");
        } else {
            // Handle the case where the JobRecruiter with the provided ID does not exist
            // You can return an error response with a 404 Not Found status code
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + jobRecruiterId + " not found.");
        }
    }

    
    @GetMapping("recruiters/viewJobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    // Other endpoints and methods...
}
