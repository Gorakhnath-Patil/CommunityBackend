package com.dirt.home.controller;

import com.dirt.home.dto.ResponseDto;
import com.dirt.home.dto.TwoFactorAuthDto;
import com.dirt.home.service.TwoFactorAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/two-factor-auth")
public class TwoFactorAuthController {

    private final TwoFactorAuthService twoFactorAuthService;

    @Autowired
    public TwoFactorAuthController(TwoFactorAuthService twoFactorAuthService) {
        this.twoFactorAuthService = twoFactorAuthService;
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ResponseDto> verifyOTP(@RequestParam String otp, @RequestParam Long userID) {
        ResponseDto response = twoFactorAuthService.verifyOTP(otp, userID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/enable")
    public ResponseEntity<ResponseDto> enableTwoFactorAuth(@RequestBody TwoFactorAuthDto twoFactorAuthDto) {
        ResponseDto response = twoFactorAuthService.enableTwoFactorAuth(twoFactorAuthDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/disable")
    public ResponseEntity<ResponseDto> disableTwoFactorAuth(@RequestParam Long userID) {
        ResponseDto response = twoFactorAuthService.disableTwoFactorAuth(userID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/generate-backup-codes")
    public ResponseEntity<ResponseDto> generateBackupCodes(@RequestParam Long userID) {
        ResponseDto response = twoFactorAuthService.generateBackupCodes(userID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add-trusted-device")
    public ResponseEntity<ResponseDto> addTrustedDevice(@RequestParam Long userID, @RequestParam String deviceId) {
        ResponseDto response = twoFactorAuthService.addTrustedDevice(userID, deviceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/remove-trusted-device")
    public ResponseEntity<ResponseDto> removeTrustedDevice(@RequestParam Long userID, @RequestParam String deviceId) {
        ResponseDto response = twoFactorAuthService.removeTrustedDevice(userID, deviceId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/audit-logs")
    public ResponseEntity<ResponseDto> getAuditLogs(@RequestParam Long userID) {
        ResponseDto response = twoFactorAuthService.getAuditLogs(userID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
