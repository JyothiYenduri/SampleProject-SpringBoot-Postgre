package com.talentstream.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.service.ApplicantProfileService;

@CrossOrigin("*")
@RestController
public class ApplicantProfileController {
	private final ApplicantProfileService applicantProfileService;

    @Autowired
    public ApplicantProfileController(ApplicantProfileService applicantProfileService) {
        this.applicantProfileService = applicantProfileService;
    }

   @PostMapping("/applicants/createprofile")
    public ResponseEntity<ApplicantProfile> createOrUpdateApplicantProfile(@RequestBody ApplicantProfile applicantProfile) {
        System.out.println("This method was hit");
	   ApplicantProfile savedProfile = applicantProfileService.createOrUpdateApplicantProfile(applicantProfile);
        return ResponseEntity.ok(savedProfile);
    }
   @GetMapping("/applicants/getdetails/{applicantId}")
   public ResponseEntity<ApplicantProfile> getApplicantProfileById(@PathVariable int applicantId) {
       ApplicantProfile applicantProfile = applicantProfileService.getApplicantProfileById(applicantId);
       if (applicantProfile != null) {
           return ResponseEntity.ok(applicantProfile);
       } else {
           return ResponseEntity.notFound().build();
       }
   }
       @DeleteMapping("/applicants/deletedetails/{applicantId}")
       public ResponseEntity<Void> deleteApplicantProfile(@PathVariable int applicantId) {
           applicantProfileService.deleteApplicantProfile(applicantId);
           return ResponseEntity.noContent().build();
       }
}
