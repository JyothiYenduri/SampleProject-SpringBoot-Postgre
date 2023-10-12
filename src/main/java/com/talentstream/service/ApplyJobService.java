package com.talentstream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.ApplyJob;
import com.talentstream.entity.Job;
import com.talentstream.repository.ApplyJobRepository;


@Service
public class ApplyJobService {
	 @Autowired
	   private ApplyJobRepository applyJobRepository;
	
	    public ApplyJob applyForJob(Optional<ApplicantProfile> applicant, Optional<Job> job) {
	    	ApplyJob jobApplication = new ApplyJob(applicant, job);
	        return applyJobRepository.save(jobApplication);
	    }
}
