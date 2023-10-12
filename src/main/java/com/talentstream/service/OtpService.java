package com.talentstream.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    private static final long OTP_VALID_DURATION_MS = 120 * 1000; // 120 seconds

    private Map<String, OtpData> otpMap = new HashMap<>();

    public String generateOtp(String userEmail) {
        String otp = generateRandomOtp();
        otpMap.put(userEmail, new OtpData(otp));
        return otp;
    }

    public boolean validateOtp(String userEmail, String enteredOtp) {
        OtpData otpData = otpMap.get(userEmail);
        if (otpData != null && otpData.isValid(enteredOtp)) {
            otpMap.remove(userEmail);
            return true;
        }
        return false;
    }
    public boolean isEmailAssociatedWithOtp(String userEmail) {
        return otpMap.containsKey(userEmail);
    }
    public boolean isOtpExpired(String userEmail) {
        OtpData otpData = otpMap.get(userEmail);
        if (otpData != null) {
            long currentTime = System.currentTimeMillis();
            long otpCreationTime = otpData.getCreationTime();
            return currentTime - otpCreationTime > OTP_VALID_DURATION_MS;
        }
        return true; // Return true if OTP data is not available (expired)
    }

    private String generateRandomOtp() {
        return RandomStringUtils.randomNumeric(6); // Generate a 6-digit OTP
    }

    private static class OtpData {
        private String otp;
        private long creationTime;

        public OtpData(String otp) {
            this.otp = otp;
            this.creationTime = System.currentTimeMillis();
        }

        public boolean isValid(String enteredOtp) {
            long currentTime = System.currentTimeMillis();
            return currentTime - creationTime <= OTP_VALID_DURATION_MS && otp.equals(enteredOtp);
        }

        public long getCreationTime() {
            return creationTime;
        }
    }
}
