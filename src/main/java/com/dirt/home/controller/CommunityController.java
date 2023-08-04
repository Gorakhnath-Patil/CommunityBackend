package com.dirt.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dirt.home.model.Community;
import com.dirt.home.service.CommunityService;

@RestController
@RequestMapping("/communities")
public class CommunityController {
    private final CommunityService communityService;

    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public ResponseEntity<List<Community>> getAllCommunities() {
        List<Community> communities = communityService.getAllCommunities();
        return new ResponseEntity<>(communities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getCommunityById(@PathVariable Long id) {
        Community community = communityService.getCommunityById(id);
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Community> createCommunity(@RequestBody Community community) {
        Community createdCommunity = communityService.createCommunity(community);
        return new ResponseEntity<>(createdCommunity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Community> updateCommunity(@PathVariable Long id, @RequestBody Community updatedCommunity) {
        Community community = communityService.updateCommunity(id, updatedCommunity);
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}