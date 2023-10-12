package com.talentstream.controller;

 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.talentstream.service.JwtUtil;
import com.talentstream.service.MyUserDetailsService;
import com.talentstream.service.OtpService;
import com.talentstream.response.ResponseHandler;
import com.talentstream.entity.AuthenticationResponse;
import com.talentstream.entity.JobRecruiter;
import com.talentstream.entity.RecruiterLogin;
import com.talentstream.entity.ResetPasswordRequest;
import com.talentstream.service.EmailService;
import com.talentstream.service.JobRecruiterService;

 

@RestController
@CrossOrigin("*")
public class JobRecruiterController {
	@Autowired
    private OtpService otpService;
	 private Map<String, Boolean> otpVerificationMap = new HashMap<>();


 

    @Autowired
    private EmailService emailService; // Your email service
	@Autowired
     JobRecruiterService recruiterService;
     @Autowired
	private AuthenticationManager authenticationManager;
     @Autowired
	private JwtUtil jwtTokenUtil;
     @Autowired
     MyUserDetailsService myUserDetailsService;
    @Autowired
    public JobRecruiterController(JobRecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }
   @PostMapping("/recruiters")
    public ResponseEntity<String> registerRecruiter(@RequestBody JobRecruiter recruiter) {
        return recruiterService.saveRecruiter(recruiter);
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<Object> login(@RequestBody RecruiterLogin loginRequest) throws Exception {
//        boolean loginResult = recruiterService.login(loginRequest.getEmail(), loginRequest.getPassword());
//
// 
//
//        System.out.println(loginResult);
//        System.out.println(loginRequest.getEmail());
//
//        if (loginResult) {
//        	return createAuthenticationToken(loginRequest);
//        } else {
//            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
//        }
//    }
    @PostMapping("/recruiterLogin")
    public ResponseEntity<Object> login(@RequestBody RecruiterLogin loginRequest) throws Exception {
       JobRecruiter recruiter = recruiterService.login(loginRequest.getEmail(), loginRequest.getPassword());
        System.out.println(loginRequest.getEmail());
        System.out.println(recruiter.getEmail());

        if (recruiter!=null) {
        	return createAuthenticationToken(loginRequest,recruiter);
        } else {
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/recruiters/registration-send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody ResetPasswordRequest request) {
        String userEmail = request.getEmail();
        JobRecruiter jobRecruiter = recruiterService.findByEmail(userEmail);

        if (jobRecruiter == null) {
           // return ResponseEntity.badRequest().body("Email is not registered.");
       String otp = otpService.generateOtp(userEmail);
            //tempEmailStorage.put(userEmail, userEmail);
            // Send OTP email using EmailService
            emailService.sendOtpEmail(userEmail, otp);
            otpVerificationMap.put(userEmail, true); // Mark OTP as verified
            return ResponseEntity.ok("OTP sent to your email.");
        }
        else {
        	 return ResponseEntity.badRequest().body("Email is already  registered.");
        }
    }

    private ResponseEntity<Object> createAuthenticationToken(RecruiterLogin login, JobRecruiter recruiter) throws Exception {
		// TODO Auto-generated method stub
    	try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
    	final UserDetails userDetails = myUserDetailsService.loadUserByUsername(recruiter.getEmail());

 

		final String jwt = jwtTokenUtil.generateToken(userDetails);

 

  
		return ResponseHandler.generateResponse("Login successfully"+userDetails.getAuthorities(), HttpStatus.OK, new AuthenticationResponse(jwt),recruiter.getEmail(),recruiter.getCompanyname(),recruiter.getRecruiterId());
	}

 

	@GetMapping("/viewRecruiters")
    public ResponseEntity<List<JobRecruiter>> getAllJobRecruiters() {
        List<JobRecruiter> jobRecruiters = recruiterService.getAllJobRecruiters();
        return ResponseEntity.ok(jobRecruiters);
    }
}