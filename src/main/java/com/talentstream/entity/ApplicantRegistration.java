package com.talentstream.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data

@Entity

public class ApplicantRegistration {

	@Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

 

    private String name;

    private String email;

    private String mobilenumber;

    private String password;
    @Column(nullable = false)
    private String roles="ROLE_JOBAPPLICANT"; 
    

	  public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public long getId() {

		return id;

	}

	public void setId(long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getMobilenumber() {

		return mobilenumber;

	}

	public void setMobilenumber(String mobilenumber) {

		this.mobilenumber = mobilenumber;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	

	

		

 

}