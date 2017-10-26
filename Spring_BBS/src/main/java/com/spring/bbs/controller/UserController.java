package com.spring.bbs.controller;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.bbs.command.UserCommand;
import com.spring.bbs.command.UserLoginCommand;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
@SessionAttributes("id")
public class UserController {
	
	UserCommand command = null;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		return "home";
	}
	
	@RequestMapping("home")
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		System.out.println("login()");
		
		return "login";
		
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(HttpServletRequest request, Model model) {
		System.out.println("loginAction()");
		
		model.addAttribute("request", request);
		command = new UserLoginCommand();
		int result = command.execute(model);
		
		if(result == 1){//로그인 성공
			System.out.println("로그인 성공 ");
			
			model.addAttribute("id", request.getParameter("userEmail"));
	        //session 객체에 admin이라는 값을 id라는 키로 저장
	        
			return "home";
			
		}
		else if(result == 0){
			System.out.println("로그인 실패 " + result + "패스워드 오류 ");
			return "login";
		}
		else if(result == -1){
			System.out.println("로그인 실패 " + result + "존재하지 않는 아이디" );
			return "login";
		}
		else if(result == -2){
			System.out.println("로그인 실패 " + result + "데이터베이스 오류 ");
			return "login";
		}
		
		return "redirect:/home";
		
	}
	
	@RequestMapping("/logoutAction")
	public String logoutAction(Model model) {
		System.out.println("logoutAction()");
		model.addAttribute("id", "Guest");
		
		return "home";
		
	}

}
