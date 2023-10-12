package com.talentstream.entity;

public class ResetPasswordRequest {
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ResetPasswordRequest(String email) {
		super();
		this.email = email;
	}

	public ResetPasswordRequest() {
		super();
	}
   

    // Getters and setters
    
    
}