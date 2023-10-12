package com.talentstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.talentstream.entity.CompanyProfile;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.repository.CompanyProfileRepository;

import java.util.Optional;

@Service
public class CompanyProfileService {

    private final CompanyProfileRepository companyProfileRepository;

    @Autowired
    public CompanyProfileService(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

//    public CompanyProfile saveCompanyProfile(CompanyProfile companyProfile) {
//        return companyProfileRepository.save(companyProfile);
//    }

    
    public CompanyProfile saveCompanyProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }

    public Optional<CompanyProfile> getCompanyProfileById(Long id) {
        return companyProfileRepository.findById(id);
    }

    // You can add more methods as needed, such as updating, deleting, or querying company profiles
}
