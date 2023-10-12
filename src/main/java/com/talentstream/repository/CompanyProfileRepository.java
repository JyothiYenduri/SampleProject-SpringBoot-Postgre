package com.talentstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentstream.entity.CompanyProfile;
import com.talentstream.entity.JobRecruiter;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {

	JobRecruiter findByEmail(String username);
    // You can add custom query methods here if needed
}
