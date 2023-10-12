package com.talentstream.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RecuriterSkills {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//		      cascade = {
//		              CascadeType.PERSIST,
//		              CascadeType.MERGE
//		          })
//	 @JsonIgnore
//    private Set<Job> jobs=new HashSet<>();

    
//	public Set<Job> getJobs() {
//		return jobs;
//	}
//
//	public void setJobs(Set<Job> jobs) {
//		this.jobs = jobs;
//	}

	@Column(nullable = false)
    private String skillName;

	@Column(nullable = false, columnDefinition = "int default 0")
	private int minimumExperience;

   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getMinimumExperience() {
		return minimumExperience;
	}

	public void setMinimumExperience(int minimumExperience) {
		this.minimumExperience = minimumExperience;
	}
    
    
}
