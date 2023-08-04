package com.dirt.home.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.dirt.home.dto.VoteDto;
import com.dirt.home.dto.VoteMapper;
import com.dirt.home.model.Vote;

@Component
@Mapper(componentModel = "spring")
public class VoteMapperImpl implements VoteMapper {

    @Override
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    public VoteDto toVoteDto(Vote vote) {
        // Implement the mapping logic here
        // This method should map Vote to VoteDto
        // You can use MapStruct's generated methods or custom mappings
        return null;
    }

    @Override
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    public Vote toVote(VoteDto voteDto) {
        // Implement the mapping logic here
        // This method should map VoteDto to Vote
        // You can use MapStruct's generated methods or custom mappings
        return null;
    }

    @Override
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    public void updateVoteFromDto(VoteDto voteDto, @MappingTarget Vote vote) {
        // Implement the mapping logic here
        // This method should update an existing Vote entity with data from VoteDto
        // You can use MapStruct's generated methods or custom mappings
    }
}