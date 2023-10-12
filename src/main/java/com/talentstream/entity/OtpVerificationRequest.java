package com.talentstream.entity;

public class OtpVerificationRequest {

    public OtpVerificationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String otp;
    private String email;
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public OtpVerificationRequest(String otp, String email) {
		super();
		this.otp = otp;
		this.email = email;
	}
    

}
