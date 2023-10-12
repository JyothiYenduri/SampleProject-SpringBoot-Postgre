package com.talentstream.entity;

public class NewPasswordRequest {

    public NewPasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String newPassword;
    private String confirmedPassword;
    

    // Constructors, getters, setters
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public NewPasswordRequest(String newPassword, String confirmedPassword) {
		super();
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}
     
    
}
