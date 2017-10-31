package com.spring.bbs.dao;

import java.sql.*;

import com.spring.bbs.dto.UserDTO;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt_pw;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/spring_BBS";
			String dbID = "root";
			String dbPassword = "gusqja12";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate(){
		String SQL = "SELECT NOW()";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public int login(String userEmail, String userPassword) {
		String  SQL = "SELECT userId FROM USER WHERE userEmail = ?";
		String  SQL_pw = "SELECT userPassword FROM PW WHERE userId = ?";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pstmt_pw = conn.prepareStatement(SQL_pw);
				pstmt_pw.setString(1, rs.getString(1));
				rs = pstmt_pw.executeQuery();
			
				if(rs.next()) {
					if(rs.getString(1).equals(userPassword))
						return 1;
					else 
						return 0;
				}
				return -1;
			}
			return -1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public int join(UserDTO user) {
		String SQL = "INSERT INTO USER VALUES(?, ?, ?, ?, ?, ?, ?)";
		String SQL_pw = "INSERT INTO PW VALUES(?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserEmail());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserTel());
			pstmt.setInt(6, user.getUserGrade());
			pstmt.setString(7, getDate());
			if(pstmt.executeUpdate() == 1){				
				pstmt_pw = conn.prepareStatement(SQL_pw);
				pstmt_pw.setString(1, user.getUserId());
				pstmt_pw.setString(2, user.getUserPassword());
			}			
			return pstmt_pw.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
