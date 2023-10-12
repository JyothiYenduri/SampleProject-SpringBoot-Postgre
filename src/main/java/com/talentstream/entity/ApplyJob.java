
package com.talentstream.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.talentstream.entity.ApplicantProfile;
import com.talentstream.entity.Job;

@Entity
@Table(name="Applyjob")
public class ApplyJob {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applyjobid;


	@ManyToOne	
	private ApplicantProfile applicantProfile;
	

    @ManyToOne
   // @JoinColumn(name = "job_id")
   private Job job;


    @Column(nullable = false)
    private Date applicationDate;

    // Constructors, getters, and setters

    public ApplyJob(Optional<ApplicantProfile> applicant2, Optional<Job> job2) {
        this.applicationDate = new Date();
    }

	

	public ApplyJob(ApplicantProfile applicant2, Job job2) 
	{
		applicantProfile=applicant2;
		job=job2;
	}

	public Long getId() {
		return applyjobid;
	}

	public void setId(Long id) {
		this.applyjobid = id;
	}

	public ApplicantProfile getApplicant() {
		return applicantProfile;
	}

	public void setApplicant(ApplicantProfile applicant) {
		this.applicantProfile = applicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

   
}
