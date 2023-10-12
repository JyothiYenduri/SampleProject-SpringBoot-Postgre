package com.talentstream.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.ApplicantSkills;
import com.talentstream.entity.Job;
import com.talentstream.entity.RecommendedJob;
import com.talentstream.entity.RecuriterSkills;
import com.talentstream.repository.ApplicantProfileRepository;
import com.talentstream.repository.JobRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class RecommendedJobsService {

    @Autowired
    private ApplicantProfileRepository applicantProfileRepository;

    @Autowired
    private JobRepository jobRepository;
    public List<RecommendedJob> getRecommendedJobsForApplicant(int applicantId) {
        java.util.Optional<ApplicantProfile> applicantProfileOptional = applicantProfileRepository.findById(applicantId);

        if (applicantProfileOptional.isPresent()) {
            ApplicantProfile applicant = applicantProfileOptional.get();

            // Fetch jobs from the repository
            List<Job> allJobs = jobRepository.findAll();

            // Filter and recommend jobs based on matching skills
            List<RecommendedJob> recommendedJobs = allJobs.stream()
                .filter(job -> hasMatchingSkill(applicant.getSkillsRequired(), job.getSkillsRequired()))
                .map(job -> new RecommendedJob(
                    applicantId,
                    job.getId(),
                    job.getJobTitle(),
                    job.getJobRecruiter().getCompanyname(),
                    job.getLocation(),
                    job.getMaxSalary(),
                    job.getMinSalary(),
                    getMinimumExperience(job.getSkillsRequired()),
                    job.getMaximumExperience()
                ))
                .collect(Collectors.toList());

            return recommendedJobs;
        } else {
            return Collections.emptyList();
        }
    }

    // Helper method to check if an applicant has matching skills for a job
    private boolean hasMatchingSkill(Set<ApplicantSkills> applicantSkills, Set<RecuriterSkills> jobSkills) {
        return applicantSkills.stream()
            .anyMatch(applicantSkill -> jobSkills.stream()
                .anyMatch(jobSkill -> applicantSkill.getSkillName().equalsIgnoreCase(jobSkill.getSkillName())
                    && applicantSkill.getExperience() >= jobSkill.getMinimumExperience()));
    }

    // Helper method to calculate the minimum experience required for a job
    private int getMinimumExperience(Set<RecuriterSkills> jobSkills) {
        return jobSkills.stream()
            .map(RecuriterSkills::getMinimumExperience)
            .min(Integer::compareTo)
            .orElse(0); 
    }
    }