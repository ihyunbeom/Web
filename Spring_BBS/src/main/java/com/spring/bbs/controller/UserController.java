package com.spring.bbs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bbs.command.UserCommand;
import com.spring.bbs.command.UserLoginCommand;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class UserController {
	
	UserCommand command = null;
	
	@RequestMapping("/login")
	public String login(Model model) {
		System.out.println("login()");
		
		return "login";
		
	}

}
