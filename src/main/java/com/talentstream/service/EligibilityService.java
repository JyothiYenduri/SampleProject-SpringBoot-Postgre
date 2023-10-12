package com.talentstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentstream.entity.Eligibility;
import com.talentstream.repository.EligibilityRepository;

@Service
public class EligibilityService {
    EligibilityRepository eligibilityRepository;

    @Autowired
    public EligibilityService(EligibilityRepository eligibilityRepository) {
        this.eligibilityRepository = eligibilityRepository;
    }

    public Eligibility saveEligibility(Eligibility eligibility) {
        return eligibilityRepository.save(eligibility);
    }

    // Other methods if needed
}
