package com.dirt.home.service;

import java.util.List;

import com.dirt.home.model.Community;

public interface CommunityService {
    List<Community> getAllCommunities();
    Community updateCommunity(Long id, Community updatedCommunity);
    Community getCommunityById(Long id);
    Community createCommunity(Community community);
  
    void deleteCommunity(Long id);
}
