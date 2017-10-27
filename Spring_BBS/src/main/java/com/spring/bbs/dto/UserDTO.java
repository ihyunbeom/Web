package com.spring.bbs.dto;

public class UserDTO {
	
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userCreated;
	private String userTel;
	
	public UserDTO(){
		
	}
	
	public UserDTO(String email, String password, String name, String gender, String created, String tel){
		this.userEmail = email;
		this.userPassword = password;
		this.userName = name;
		this.userGender = gender;
		this.userCreated = created;
		this.userTel = tel;	
		
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	

}
