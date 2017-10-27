package com.spring.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.spring.bbs.dto.BbsDTO;



public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs;

	public BbsDAO() {
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
	
	public int getNext(){
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1) + 1;
			}
			return 1; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; 
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
		return "";//데이터베이스 오류
	}
	
	
	public ArrayList<BbsDTO> getList() {
		
		ArrayList<BbsDTO> listDTO = new ArrayList<BbsDTO>();
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext());
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				int bbsID = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userEmail = rs.getString("userEmail");
				String bbsCreated = rs.getString("bbsCreated");				
				String bbsContent = rs.getString("bbsContent");				
				int bbsAvailable = rs.getInt("bbsAvailable");
				
				
				BbsDTO bbsDTO = new BbsDTO(bbsID, bbsTitle, userEmail, bbsCreated, bbsContent, bbsAvailable);
				listDTO.add(bbsDTO);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		return listDTO;
	}
	
	public int write(String bbsTitle, String userEmail, String bbsContent){
		String SQL = "INSERT INTO BBS VALUES (?, ?, ?, ?, ?, ?)";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext());
			pstmt.setString(2,  bbsTitle);
			pstmt.setString(3,  userEmail);
			pstmt.setString(4,  getDate());
			pstmt.setString(5,  bbsContent);
			pstmt.setInt(6,  1);		
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public BbsDTO getBbs(int strID){
		String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		BbsDTO bbsDTO = new BbsDTO();
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  strID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				int bbsID = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userEmail = rs.getString("userEmail");
				String bbsCreated = rs.getString("bbsCreated");				
				String bbsContent = rs.getString("bbsContent");				
				int bbsAvailable = rs.getInt("bbsAvailable");
				
				
				bbsDTO = new BbsDTO(bbsID, bbsTitle, userEmail, bbsCreated, bbsContent, bbsAvailable);
				System.out.println("(DAO)BbsTitle : " + bbsDTO.getBbsTitle());
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bbsDTO;
	}
	
	public int update(int bbsID, String bbsTitle, String bbsContent){
		String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID = ?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  bbsTitle);
			pstmt.setString(2,  bbsContent);
			pstmt.setInt(3,  bbsID);
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public int delete(int bbsID){
		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  bbsID);
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	/*
	public BbsDTO contentView(String strID) {
		// TODO Auto-generated method stub
		String SQL = "SELECT * from BBS where bbsID = ?";
		BbsDTO bbsDTO = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int bbsID = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userEmail = rs.getString("userEmail");
				String bbsCreated = rs.getString("bbsCreated");
				String bbsContent = rs.getString("bbsContent");
				int bbsAvailable = rs.getInt("bbsAvailable");
				
				bbsDTO = new BbsDTO(bbsID, bbsTitle, userEmail, bbsCreated, bbsContent, bbsAvailable);
				
				bbsDTO.setBbsID(rs.getInt(1));
				bbsDTO.setBbsTitle(rs.getString(2));
				bbsDTO.setUserEmail(rs.getString(3));
				bbsDTO.setBbsCreated(rs.getString(4));
				bbsDTO.setBbsContent(rs.getString(5));
				bbsDTO.setBbsAvailable(rs.getInt(6));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return bbsDTO;
	}
	*/

	
}
