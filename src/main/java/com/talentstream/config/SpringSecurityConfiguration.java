package com.talentstream.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.talentstream.filter.JwtRequestFilter;
import com.talentstream.service.JobRecruiterService;


@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	//@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
//	 @Autowired
//	    private JobRecruiterService jobRecruiterService;

	//@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder()); 
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable()
		
		.authorizeRequests()
		.antMatchers("/recruiters/company-profiles/{jobRecruiterId}","/recruiters/getCompanyProfile/{id}","/recruiters/saveJob/{jobRecruiterId}","recruiters/viewJobs").hasAnyRole("JOBRECRUITER")
		.antMatchers("/applicant/findjob/{applicantId}","/applicants/recommended-jobs/{id}","/viewApplicants","/applicants/createprofile","/applicants/getdetails/{applicantId}","/applicants/deletedetails/{applicantId}","/applicants/recommended-jobs/{applicantId}","/applicants/allapplicants/recommended-jobs","/applicants/job/{applicantId}/{jobId}","/applicants/viewjob/{jobId}","/applicants/applyjob").hasAnyRole("JOBAPPLICANT")
	    .antMatchers("/recruiters","/signOut","/applicant/forgotpassword/sendotp","/recruiterLogin","/recruiters/send-otp","/recruiters/verify-otp","/saveApplicant","/recruiters/registration-send-otp","/applicantLogin","/applicant/sendotp","/applicants/verify-otp","/applicants/reset-password/{email}","/recruiters/reset-password/set-new-password/{email}").permitAll()
						.anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	// @Override
//	    protected void configure(HttpSecurity httpSecurity) throws Exception {
//	        httpSecurity.csrf().disable()
//	                .authorizeRequests()
//	                    .antMatchers("/authenticate", "/send-otp", "/verify-otp", "/saveRecruiters", "/saveApplicant", "/registration-send-otp", "/applicantLogin").permitAll()
//	                    .anyRequest().authenticated()
//	                .and()
//	                .exceptionHandling()
//	                .and()
//	                .sessionManagement()
//	                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	 .and()
//    .httpBasic().disable()
//    .formLogin().disable();
//
//        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
}

	