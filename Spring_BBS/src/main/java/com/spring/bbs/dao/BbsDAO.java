package com.spring.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.spring.bbs.dto.BbsDTO;
import com.spring.bbs.dto.ReplyDTO;

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
	
	public int getNext(String value, String table){
		String SQL = "SELECT "+value+" FROM "+table+" ORDER BY "+value+" DESC";
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
		return "";
	}
	
	
	public ArrayList<BbsDTO> getList(int pageNumber) {
		
		ArrayList<BbsDTO> listDTO = new ArrayList<BbsDTO>();
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext("bbsId", "BBS") - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				int bbsID = rs.getInt("bbsID");
				String bbsTitle = rs.getString("bbsTitle");
				String userName = rs.getString("userName");
				String userEmail = rs.getString("userEmail");
				String bbsCreated = rs.getString("bbsCreated");				
				String bbsContent = rs.getString("bbsContent");				
				int bbsAvailable = rs.getInt("bbsAvailable");
				
				
				BbsDTO bbsDTO = new BbsDTO(bbsID, bbsTitle, userName, userEmail, bbsCreated, bbsContent, bbsAvailable);
				listDTO.add(bbsDTO);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		return listDTO;
	}
	
	public int write(String bbsTitle, String userEmail, String bbsContent){
		String SQL = "INSERT INTO BBS VALUES (?, ?, ?, ?, ?, ?, ?)";
		String SQL2 = "SELECT *FROM USER WHERE userEmail = ?";
		
		String userName=null;
		
		
		try{
			PreparedStatement pstmt2 = conn.prepareStatement(SQL2);
			pstmt2.setString(1, userEmail);
			rs = pstmt2.executeQuery();
			while(rs.next()){
				userName = rs.getString("userName");				
			}
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext("bbsId","BBS"));
			pstmt.setString(2,  bbsTitle);
			pstmt.setString(3,  userName);
			pstmt.setString(4,  userEmail);
			pstmt.setString(5,  getDate());
			pstmt.setString(6,  bbsContent);
			pstmt.setInt(7,  1);		
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; 
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
				String userName = rs.getString("userName");
				String userEmail = rs.getString("userEmail");
				String bbsCreated = rs.getString("bbsCreated");				
				String bbsContent = rs.getString("bbsContent");				
				int bbsAvailable = rs.getInt("bbsAvailable");
				
				bbsDTO = new BbsDTO(bbsID, bbsTitle, userName, userEmail, bbsCreated, bbsContent, bbsAvailable);
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
		return -1; 
	}
	
	public int delete(String bbsID){
		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  bbsID);
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; 
	}
	
	public boolean nextPage(int pageNumber){
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1";
		try{
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext("bbsId","BBS") - (pageNumber - 1) * 10);
			rs = pstmt.executeQuery();
			while(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<ReplyDTO> getReply(int bbsID) {
		
		ArrayList<ReplyDTO> listDTO = new ArrayList<ReplyDTO>();
		String SQL = "SELECT * FROM REPLY WHERE bbsId = ? AND replyAvailable = 1 ORDER BY replyId ASC";
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				int replyId = rs.getInt("replyId");
				int bbsId = rs.getInt("bbsId");
				String userEmail = rs.getString("userEmail");
				String userName = rs.getString("userName");
				String replyContent = rs.getString("replyContent");
				String replyCreated = rs.getString("replyCreated");		
				int replyAvailable = rs.getInt("replyAvailable");
				
				ReplyDTO replyDTO = new ReplyDTO(replyId, bbsId, userEmail, userName, replyContent, replyCreated, replyAvailable);
				listDTO.add(replyDTO);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		return listDTO;
	}
	
	public int reply_write(int bbsId, String userEmail, String replyContent){
		String userName="Guest";
		
		String SQL = "INSERT INTO REPLY VALUES (?, ?, ?, ?, ?, ?, ?)";
		String SQL2 = "SELECT userName FROM USER WHERE userEmail = ?";
		//userEmail => 추후에 세션값으로 userId로 바꾸면, userId로 수정
		
		/*
		 	replyId int(11),
			bbsId int(11),
			userEmail varchar(20),
			userName varchar(20),
			replyContent varchar(2048),
			replyCreated varchar(50),
			replyAvailable int,
		 */
		
		try{
			PreparedStatement pstmt2 = conn.prepareStatement(SQL2);
			pstmt2.setString(1, userEmail);
			rs = pstmt2.executeQuery();
			while(rs.next()){
				userName = rs.getString("userName");				
			}
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,  getNext("replyId","REPLY"));
			pstmt.setInt(2,  bbsId);
			pstmt.setString(3,  userEmail);
			pstmt.setString(4,  userName);
			pstmt.setString(5,  replyContent);
			pstmt.setString(6, getDate());
			pstmt.setInt(7,  1);		
			
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; 
	}

}
