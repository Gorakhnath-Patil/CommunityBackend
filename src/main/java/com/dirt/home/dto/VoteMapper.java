package com.dirt.home.dto;

import com.dirt.home.model.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    VoteMapper INSTANCE = Mappers.getMapper(VoteMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    VoteDto toVoteDto(Vote vote);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    Vote toVote(VoteDto voteDto);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "post.id")
    void updateVoteFromDto(VoteDto voteDto, @MappingTarget Vote vote);
}
