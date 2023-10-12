package com.talentstream.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.repository.ApplicantProfileRepository;

@Service
public class ApplicantProfileService {
	 private final ApplicantProfileRepository applicantProfileRepository;

	    @Autowired
	    public ApplicantProfileService(ApplicantProfileRepository applicantProfileRepository) {
	        this.applicantProfileRepository = applicantProfileRepository;
	    }

	    public ApplicantProfile createOrUpdateApplicantProfile(ApplicantProfile applicantProfile) {
	        return applicantProfileRepository.save(applicantProfile);
	    }

	    public ApplicantProfile getApplicantProfileById(long applicantId) {
	        return applicantProfileRepository.findById((int) applicantId).orElse(null);
	    }

	    public void deleteApplicantProfile(long applicantId) {
	        applicantProfileRepository.deleteById((int) applicantId);
	    }

}
