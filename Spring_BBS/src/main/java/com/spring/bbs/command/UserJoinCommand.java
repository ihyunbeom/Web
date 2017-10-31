package com.spring.bbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.UserDAO;
import com.spring.bbs.dto.UserDTO;

public class UserJoinCommand implements UserCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userTel = request.getParameter("userTel");
		int userGrade = 0; //가입신청
		String userCreated = request.getParameter("userCreated");
		
		UserDTO user=null;
		if(userId.equals("") || userEmail.equals("") || userPassword.equals("") || 
				userName.equals("") || userGender.equals("") || userTel.equals("")){	
		
			return -2;
			
		}else{
			user = new UserDTO(userId, userEmail,userPassword,userName,userGender,userTel,userGrade,userCreated);
			UserDAO dao = new UserDAO();
			
			return dao.join(user);
		}
	}

}
