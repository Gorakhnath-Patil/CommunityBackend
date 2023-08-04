package com.dirt.home.service;

import com.dirt.home.dto.VoteDto;
import com.dirt.home.dto.VoteMapper;
import com.dirt.home.exception.ResourceNotFoundException;
import com.dirt.home.model.Vote;
import com.dirt.home.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final VoteMapper voteMapper;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository, VoteMapper voteMapper) {
        this.voteRepository = voteRepository;
        this.voteMapper = voteMapper;
    }

    @Override
    public void createVote(VoteDto voteDto) {
        Vote vote = voteMapper.toVote(voteDto);
        voteRepository.save(vote);
    }

    @Override
    public VoteDto getVoteById(Long id) {
        Vote vote = voteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vote", "id", id));
        return voteMapper.toVoteDto(vote);
    }

    @Override
    public void updateVote(Long id, VoteDto voteDto) {
        Vote vote = voteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vote", "id", id));
        voteMapper.updateVoteFromDto(voteDto, vote);
        voteRepository.save(vote);
    }

    @Override
    public void deleteVote(Long id) {
        Vote vote = voteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vote", "id", id));
        voteRepository.delete(vote);
    }
}
