package com.spring.bbs.dao;

import java.sql.*;

import com.spring.bbs.dto.UserDTO;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
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
	
	public int login(String userEmail, String userPassword) {
		String  SQL = "SELECT userPassword FROM USER WHERE userEmail = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword))
					return 1;
				else 
					return 0;
			}
			return -1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public int join(UserDTO user) {
		String SQL = "INSERT INTO USER VALUES(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserCreated());
			pstmt.setString(6, user.getUserTel());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
