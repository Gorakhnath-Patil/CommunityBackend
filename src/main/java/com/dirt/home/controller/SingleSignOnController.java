package com.dirt.home.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dirt.home.model.SingleSignOn;
import com.dirt.home.service.SingleSignOnService;

@RestController
@RequestMapping("/api/single-sign-on")
public class SingleSignOnController {

    private final SingleSignOnService singleSignOnService;

    public SingleSignOnController(SingleSignOnService singleSignOnService) {
        this.singleSignOnService = singleSignOnService;
    }

    // Endpoint to save or update SingleSignOn details
    @PostMapping("/save")
    public ResponseEntity<SingleSignOn> saveSingleSignOn(@RequestBody SingleSignOn singleSignOn) {
        SingleSignOn savedSingleSignOn = singleSignOnService.saveSingleSignOn(singleSignOn);
        return new ResponseEntity<>(savedSingleSignOn, HttpStatus.CREATED);
    }

    // Endpoint to get SingleSignOn details by user ID
    @GetMapping("/{userId}")
    public ResponseEntity<SingleSignOn> getSingleSignOnByUserId(@PathVariable Long userId) {
        SingleSignOn singleSignOn = singleSignOnService.getSingleSignOnByUserId(userId);
        if (singleSignOn != null) {
            return new ResponseEntity<>(singleSignOn, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete SingleSignOn details by user ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteSingleSignOnByUserId(@PathVariable Long userId) {
        singleSignOnService.deleteSingleSignOnByUserId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
