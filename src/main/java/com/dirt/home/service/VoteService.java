package com.dirt.home.service;

import com.dirt.home.dto.VoteDto;

public interface VoteService {
    void createVote(VoteDto voteDto);
    VoteDto getVoteById(Long id);
    void updateVote(Long id, VoteDto voteDto);
    void deleteVote(Long id);
}
