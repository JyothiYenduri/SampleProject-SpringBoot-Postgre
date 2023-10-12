package com.talentstream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentstream.entity.SavedJob;
@Repository
public interface SavedJobRepository extends JpaRepository<SavedJob, Long> {
   
}
