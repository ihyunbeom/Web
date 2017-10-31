package com.spring.bbs.dto;

import java.sql.Timestamp;

public class BbsDTO {

	int bbsID;
	String bbsTitle;
	String userEmail;
	String bbsCreated;
	String bbsContent;
	int bbsAvailable;
	
	public BbsDTO() {
		
	}
	
	public BbsDTO(int bbsID, String bbsTitle, String userEmail, String bbsCreated, String bbsContent, int bbsAvailable) {
		
		this.bbsID = bbsID;
		this.bbsTitle = bbsTitle;
		this.userEmail = userEmail;
		this.bbsCreated = bbsCreated;
		this.bbsContent = bbsContent;
		this.bbsAvailable = bbsAvailable;
		
	}
	
	public int getBbsID() {
		return bbsID;
	}
	public void setBbsID(int bbsID) {
		this.bbsID = bbsID;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getBbsCreated() {
		return bbsCreated;
	}
	public void setBbsCreated(String bbsCreated) {
		this.bbsCreated = bbsCreated;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public int getBbsAvailable() {
		return bbsAvailable;
	}
	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}
	
	
}
