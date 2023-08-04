package com.dirt.home.dto;

public class TwoFactorAuthDto {

    private Long userID;
    private String secretKey;
    private boolean enabled;
    // Add other fields as needed

    // Getters and Setters for the fields

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
