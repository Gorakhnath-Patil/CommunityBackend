package com.dirt.home.service;

import com.dirt.home.dto.ResponseDto;
import com.dirt.home.dto.TwoFactorAuthDto;

public interface TwoFactorAuthService {

    ResponseDto verifyOTP(String otp, Long userID);

    ResponseDto enableTwoFactorAuth(TwoFactorAuthDto twoFactorAuthDto);

    ResponseDto disableTwoFactorAuth(Long userID);

    ResponseDto generateBackupCodes(Long userID);

    ResponseDto addTrustedDevice(Long userID, String deviceId);

    ResponseDto removeTrustedDevice(Long userID, String deviceId);

    ResponseDto getAuditLogs(Long userID);
}
