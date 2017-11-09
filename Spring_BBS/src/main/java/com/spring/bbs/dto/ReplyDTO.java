package com.spring.bbs.dto;

public class ReplyDTO {
	int replyId;
	int bbsId;
	String userId;
	String userName;
	String replyContent;
	String replyCreated;
	int replyAvailable;
	
	public ReplyDTO(int replyId, int bbsId, String userId, String userName, String replyContent, String replyCreated, int replyAvailable) {
		this.replyId = replyId;
		this.bbsId = bbsId;
		this.userId = userId;
		this.userName = userName;
		this.replyContent = replyContent;
		this.replyCreated = replyCreated;
		this.replyAvailable = replyAvailable;
		
	}
	
	public int getReplyAvailable() {
		return replyAvailable;
	}
	public void setReplyAvailable(int replyAvailable) {
		this.replyAvailable = replyAvailable;
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyCreated() {
		return replyCreated;
	}
	public void setReplyCreated(String replyCreated) {
		this.replyCreated = replyCreated;
	}

}
