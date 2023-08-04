package com.dirt.home.controller;

import com.dirt.home.dto.ResponseDto;
import com.dirt.home.dto.VoteDto;
import com.dirt.home.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createVote(@RequestBody VoteDto voteDto) {
        voteService.createVote(voteDto);
        return new ResponseEntity<>(new ResponseDto("success", "Vote created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoteDto> getVoteById(@PathVariable Long id) {
        VoteDto voteDto = voteService.getVoteById(id);
        return new ResponseEntity<>(voteDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateVote(@PathVariable Long id, @RequestBody VoteDto voteDto) {
        voteService.updateVote(id, voteDto);
        return new ResponseEntity<>(new ResponseDto("success", "Vote updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteVote(@PathVariable Long id) {
        voteService.deleteVote(id);
        return new ResponseEntity<>(new ResponseDto("success", "Vote deleted successfully"), HttpStatus.OK);
    }
}
