package com.talentstream.entity;

import jakarta.persistence.Entity;

@Entity

public class RecommendedJob {

	private int applicantId;

    private Long jobId;

    private String jobTitle;

    private String companyName;

    private String location;

    private double minSalary;

    private double maxSalary;

    private int minExperience;

    private int maxExperience;

    	public RecommendedJob(long l, Long jobId, String jobTitle, String companyName, String location,

			double minSalary, double maxSalary, int minExperience, int maxExperience) {

		super();

		this.applicantId = (int) l;

		this.jobId = jobId;

		this.jobTitle = jobTitle;

		this.companyName = companyName;

		this.location = location;

		this.minSalary = minSalary;

		this.maxSalary = maxSalary;

		this.minExperience = minExperience;

		this.maxExperience = maxExperience;

	}

	public int getApplicantId() {

		return applicantId;

	}

	public void setApplicantId(int applicantId) {

		this.applicantId = applicantId;

	}

	public Long getJobId() {

		return jobId;

	}

	public void setJobId(Long jobId) {

		this.jobId = jobId;

	}

	public String getJobTitle() {

		return jobTitle;

	}

	public void setJobTitle(String jobTitle) {

		this.jobTitle = jobTitle;

	}

	public String getCompanyName() {

		return companyName;

	}

	public void setCompanyName(String companyName) {

		this.companyName = companyName;

	}

	public String getLocation() {

		return location;

	}

	public void setLocation(String location) {

		this.location = location;

	}

	public double getMinSalary() {

		return minSalary;

	}

	public void setMinSalary(double minSalary) {

		this.minSalary = minSalary;

	}

	public double getMaxSalary() {

		return maxSalary;

	}

	public void setMaxSalary(double maxSalary) {

		this.maxSalary = maxSalary;

	}

	public int getMinExperience() {

		return minExperience;

	}

	public void setMinExperience(int minExperience) {

		this.minExperience = minExperience;

	}

	public int getMaxExperience() {

		return maxExperience;

	}

	public void setMaxExperience(int maxExperience) {

		this.maxExperience = maxExperience;

	}

    

}
