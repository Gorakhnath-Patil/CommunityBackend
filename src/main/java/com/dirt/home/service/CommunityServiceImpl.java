package com.dirt.home.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dirt.home.model.Community;
import com.dirt.home.repository.CommunityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    @Override
    public Community getCommunityById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Community not found with id: " + id));
    }

    @Override
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public Community updateCommunity(Long id, Community updatedCommunity) {
        Community existingCommunity = getCommunityById(id);
        existingCommunity.setName(updatedCommunity.getName());
        existingCommunity.setDescription(updatedCommunity.getDescription());
        // Set other properties if applicable
        return communityRepository.save(existingCommunity);
    }

    @Override
    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }
}