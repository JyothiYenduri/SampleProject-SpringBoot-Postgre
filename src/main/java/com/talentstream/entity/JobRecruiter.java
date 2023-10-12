package com.talentstream.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"job"})
public class JobRecruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruiterId;

    @Column(nullable = false)
    private String companyname;

    @Column(nullable = false, unique = true)
    private String mobilenumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @OneToMany( cascade = CascadeType.ALL)
    private List<Job> jobs;
    

    @Column(nullable = false)
    private String roles="ROLE_JOBRECRUITER"; // Add the role field
// @ManyToOne
// @JoinColumn(name = "company_profile_id")
//
//  private CompanyProfile companyProfile;

    // Constructors, getters, setters, and other methods

    // Constructors

    public JobRecruiter() {
        // Default constructor
    }

    // Getters and setters

    public Long getRecruiterId() {
        return recruiterId;
    }

    public void setrecruiterId(Long recruiterId) {
        this.recruiterId = recruiterId;
    }

   
    public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getRoles() {
        return roles;
    }

    public void setRoles(String role) {
        this.roles = role;
    }

   
}
