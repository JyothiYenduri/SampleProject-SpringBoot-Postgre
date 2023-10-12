package com.talentstream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talentstream.entity.CompanyProfile;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.repository.JobRecruiterRepository;
import com.talentstream.service.CompanyProfileService;

import java.util.Optional;

@RestController
public class CompanyProfileController {
	 @Autowired
	JobRecruiterRepository jobRecruiterRepository; 
	 @Autowired
    private final CompanyProfileService companyProfileService;

    @Autowired
    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

//    @PostMapping("/save-company-profiles")
//    public ResponseEntity<String> createCompanyProfile(@RequestBody CompanyProfile companyProfile) {
//    	JobRecruiter jobRecruiter = jobRecruiterRepository.findByrecruiterId(companyProfile.getJobRecruiter().getRecruiterId());
//
//        if (jobRecruiter != null) {
//            // Associate the JobRecruiter with the CompanyProfile
//            companyProfile.setJobRecruiter(jobRecruiter);
//            // Save the CompanyProfile with the associated JobRecruiter
//            companyProfileService.saveCompanyProfile(companyProfile);
//            return ResponseEntity.status(HttpStatus.OK).body("CompanyProfile saved successfully.");
//        } else {
//            // Handle the case where the JobRecruiter with the provided ID does not exist
//            // You can return an error response with a 404 Not Found status code
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + companyProfile.getJobRecruiter().getRecruiterId() + " not found.");
//        }
//    }
    
    @PostMapping("/recruiters/company-profiles/{jobRecruiterId}")
    public ResponseEntity<String> createCompanyProfile(@RequestBody CompanyProfile companyProfile, @PathVariable Long jobRecruiterId) {
        JobRecruiter jobRecruiter = jobRecruiterRepository.findByRecruiterId(jobRecruiterId);

        if (jobRecruiter != null) {
            // Associate the JobRecruiter with the CompanyProfile
            companyProfile.setJobRecruiter(jobRecruiter);
            // Save the CompanyProfile with the associated JobRecruiter
            companyProfileService.saveCompanyProfile(companyProfile);
            return ResponseEntity.status(HttpStatus.OK).body("CompanyProfile saved successfully.");
        } else {
            // Handle the case where the JobRecruiter with the provided ID does not exist
            // You can return an error response with a 404 Not Found status code
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + jobRecruiterId + " not found.");
        }
    }


    @GetMapping("/recruiters/getCompanyProfile/{id}")
    public ResponseEntity<CompanyProfile> getCompanyProfileById(@PathVariable Long id) {
        Optional<CompanyProfile> companyProfile = companyProfileService.getCompanyProfileById(id);
        return companyProfile.map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // You can add more endpoints for updating, deleting, or querying company profiles as needed
}

