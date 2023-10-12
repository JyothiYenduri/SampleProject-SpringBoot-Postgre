package com.talentstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentstream.entity.Eligibility;

@Repository
public interface EligibilityRepository extends JpaRepository<Eligibility, Long> {
    // Custom methods if needed
}
