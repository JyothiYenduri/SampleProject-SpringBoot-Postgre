package com.talentstream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.Job;
import com.talentstream.repository.JobRepository;
@Service 
public class ViewJobService {
	@Autowired
    private JobRepository jobRepository;

    public Job getJobDetails(Long jobId) throws Exception {
        Optional<Job> jobOptional = jobRepository.findById(jobId);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
           
            Job jobDetails = new Job(          
            );

            return jobDetails;
        } else {
            // Handle the case when the specified job ID does not exist
            throw new Exception("Job not found with ID: " + jobId);
        }
    }
}
