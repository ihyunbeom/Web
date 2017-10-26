package com.spring.bbs.command;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.UserDAO;

public class UserLoginCommand implements UserCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		UserDAO userDAO = new UserDAO();
		return userDAO.login(userEmail, userPassword);
		
	}
	
}
