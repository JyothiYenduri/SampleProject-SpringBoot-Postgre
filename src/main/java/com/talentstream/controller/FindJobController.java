package com.talentstream.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

 

import com.talentstream.entity.Job;

import com.talentstream.service.FinJobService;

 

@RestController
public class FindJobController {

	private final FinJobService finJobService;

 

    @Autowired

    public FindJobController(FinJobService finJobService) {

        this.finJobService = finJobService;

    }

 

    @GetMapping("/applicant/findjob/{applicantId}")

    public List<Job> recommendJobsForApplicant(@PathVariable int applicantId) {

        //return finJobService.findRecommendedJobsByApplicantId(applicantId);
    	
    	return finJobService.getAllJobs();

    }

}