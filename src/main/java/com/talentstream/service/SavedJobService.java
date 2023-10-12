package com.talentstream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.Job;
import com.talentstream.entity.SavedJob;
import com.talentstream.repository.ApplicantProfileRepository;
import com.talentstream.repository.JobRepository;
import com.talentstream.repository.SavedJobRepository;

@Service
public class SavedJobService {
	@Autowired
    private SavedJobRepository savedJobRepository;

    @Autowired
    private ApplicantProfileRepository applicantProfileRepository;

    @Autowired
    private JobRepository jobRepository;

    public void saveJobForApplicant(long  applicantId, long jobId) throws Exception {
        // Find the applicant and job entities
        Optional<ApplicantProfile> applicantOptional = applicantProfileRepository.findById((int) applicantId);
        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if (applicantOptional.isPresent() && jobOptional.isPresent()) {
            ApplicantProfile applicant = applicantOptional.get();
            Job job = jobOptional.get();

           
            SavedJob savedJob = new SavedJob();
            savedJob.setApplicant(applicant);
            savedJob.setJob(job);

        
            savedJobRepository.save(savedJob);
        } else {
            // Handle the case when the applicant or job is not found
            throw new Exception("Applicant or job not found");
        }
    }
}

