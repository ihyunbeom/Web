package com.spring.bbs.dto;

public class UserDTO {
	
	private String userId; //학번
	private String userEmail;//로그인 id 
	private String userPassword;
	private String userName;
	private String userGender;
	private String userTel;
	private int userGrade; //0:가입신청 1:신입회원 2:일반회원 3:부관리자 4:관리자(학회장) 5:최고관리자(개발자)
	private String userCreated;//가입일
	
	
	public UserDTO(String id, String email, String password, String name, String gender, String tel, int grade, String created){
		this.userId = id;
		this.userEmail = email;
		this.userPassword = password;
		this.userName = name;
		this.userGender = gender;
		this.userTel = tel;
		this.userGrade = grade;
		this.userCreated = created;
			
		
	}
	public UserDTO(){
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
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
