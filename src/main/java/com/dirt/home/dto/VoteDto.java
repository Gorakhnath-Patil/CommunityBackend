package com.dirt.home.dto;

public class VoteDto {
    private Long voteID;
    private Long userID;
    private Long postID;
    private String voteType;
	public Long getVoteID() {
		return voteID;
	}
	public void setVoteID(Long voteID) {
		this.voteID = voteID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getPostID() {
		return postID;
	}
	public void setPostID(Long postID) {
		this.postID = postID;
	}
	public String getVoteType() {
		return voteType;
	}
	public void setVoteType(String voteType) {
		this.voteType = voteType;
	}

  
}
