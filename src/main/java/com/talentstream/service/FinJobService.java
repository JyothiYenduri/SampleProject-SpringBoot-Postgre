package com.talentstream.service;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;

import java.util.stream.Collectors;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

import com.talentstream.entity.ApplicantProfile;

import com.talentstream.entity.ApplicantSkills;

import com.talentstream.entity.Job;

import com.talentstream.entity.RecuriterSkills;

import com.talentstream.repository.ApplicantProfileRepository;

import com.talentstream.repository.JobRepository;

 

@Service

public class FinJobService {

    @Autowired

    private JobRepository jobRepository;

 

    @Autowired

    private ApplicantProfileRepository applicantProfileRepository;

 

    public List<Job> findRecommendedJobsByApplicantId(int applicantid) {

    	System.out.println("enter into the method");

        

        ApplicantProfile applicant = applicantProfileRepository.findById(applicantid)

                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + applicantid));

       

        List<Job> recommendedJobs = new ArrayList<>();

    

        Set<ApplicantSkills> applicantSkills = applicant.getSkillsRequired();

    

    	for (ApplicantSkills skill : applicantSkills) {

    	    System.out.println("Skill Name: " + skill.getSkillName());

    	    System.out.println("Minimum Experience: " + skill.getExperience());

    	   

    	}

        for (Job job : getAllJobs()) {

            Set<RecuriterSkills> jobSkills = job.getSkillsRequired();

     

            Set<String> lowercaseJobSkills = jobSkills.stream()

                    .map(skill -> skill.getSkillName().toLowerCase())

                    .collect(Collectors.toSet());

 

            Set<String> lowercaseApplicantSkills = applicantSkills.stream()

                    .map(skill -> skill.getSkillName().toLowerCase())

                    .collect(Collectors.toSet());

 

          

            if (lowercaseJobSkills.containsAll(lowercaseApplicantSkills)) {

                recommendedJobs.add(job);

            

        }

        }

 

        return recommendedJobs;

    }

 

    public List<Job> getAllJobs() {

        return jobRepository.findAll();

    }

}
