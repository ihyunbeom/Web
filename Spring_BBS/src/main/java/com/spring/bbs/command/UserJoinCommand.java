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
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userCreated = request.getParameter("userCreated");
		String userTel = request.getParameter("userTel");
		
		
		UserDTO user = new UserDTO(userEmail,userPassword,userName,userGender,userCreated,userTel);
		
		if(user.getUserEmail().equals("") || user.getUserPassword().equals("") || 
				user.getUserName().equals("") || user.getUserGender().equals("") || user.getUserTel().equals("")){
			return -2;
		}else{
			UserDAO dao = new UserDAO();
			
			return dao.join(user);
		}
	}

}
