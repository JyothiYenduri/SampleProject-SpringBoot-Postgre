package com.talentstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.Job;

import com.talentstream.repository.JobRepository;

@Service
public class JobService {
    JobRepository jobRepository;
   /// JobRecruiterRepository recruiterRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
       
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
  

    // Other methods for retrieving, updating, and deleting jobs if needed
}

