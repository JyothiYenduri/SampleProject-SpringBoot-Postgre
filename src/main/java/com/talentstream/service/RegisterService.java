package com.talentstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.talentstream.entity.ApplicantRegistration;
import com.talentstream.repository.RegisterRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RegisterService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	 @Autowired

	RegisterRepository applicantRepository;
    public RegisterService( RegisterRepository applicantRepository) {

	        this.applicantRepository = applicantRepository;

	   //     this.passwordEncoder = passwordEncoder;

	    }

 

 

public ApplicantRegistration login(String email, String password) {

	ApplicantRegistration applicant = applicantRepository.findByEmail(email);

 

//     if (applicant!= null && password.equals(applicant.getPassword())) {
//
//         return true; // Login successful
//
//     }  else {
//
//         return false; // Login failed
//
// }
	 if (applicant!= null && passwordEncoder.matches(password, applicant.getPassword())) {
         return applicant ; // Login successful
     }  else {
         return null; // Login failed
     }

}

public ApplicantRegistration findById(Long id) {

    return applicantRepository.findById(id);

     

}

public List<ApplicantRegistration> getAllApplicants() {

     return applicantRepository.findAll();

}

public void updatePassword(String userEmail, String newPassword) {

	 ApplicantRegistration jobRecruiter = applicantRepository.findByEmail(userEmail);

     if (jobRecruiter != null) {

         jobRecruiter.setPassword(newPassword);

         applicantRepository.save(jobRecruiter);

     } else {

         throw new EntityNotFoundException("JobRecruiter not found for email: " + userEmail);

 }

}

 

	public ApplicantRegistration findByEmail(String userEmail) {

		// TODO Auto-generated method stub

		return applicantRepository.findByEmail(userEmail);

	}

 

	public ApplicantRegistration findByEmailAddress(String userEmail) {

		// TODO Auto-generated method stub

		return applicantRepository.findByEmail(userEmail);

	}

 

	public ResponseEntity<String> saveapplicant(ApplicantRegistration applicant) {

		 // Check if the email already exists in the database

	     if (applicantRepository.existsByEmail(applicant.getEmail())) {

	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	    // recruiter.setPassword(passwordEncoder.encode(recruiter.getPassword()));

//	     applicant.setPassword(applicant.getPassword());
	     applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
	        
	     applicantRepository.save(applicant);

	     return ResponseEntity.ok("Applicant registered successfully");

	}

 

}