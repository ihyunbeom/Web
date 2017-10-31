package com.spring.bbs.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.bbs.command.UserCommand;
import com.spring.bbs.command.UserJoinCommand;
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
	public String loginAction(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("loginAction()");
		
		model.addAttribute("request", request);
		command = new UserLoginCommand();
		int result = command.execute(model);
		
		if(result == 1){
			System.out.println("Login Success!!! ");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('성공적으로 로그인 되었습니다.');</script>");
			out.flush();
			
			model.addAttribute("id", request.getParameter("userEmail"));
	        
			return "home";
			
		}
		else if(result == 0){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호를 확인하세요.');history.back();</script>");
			out.flush();
			return "login";
		}
		else if(result == -1){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않는 아이디입니다.');history.back();</script>");
			out.flush();
			return "login";
		}
		else if(result == -2){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('데이터베이스 오류가 발생했습니다.');history.back();</script>");
			out.flush();
			return "login";
		}
		
		return "redirect:/home";
		
	}
	
	@RequestMapping("/logoutAction")
	public String logoutAction(Model model, SessionStatus session) {
		System.out.println("logoutAction()");
		
		model.addAttribute("id", "");
		
		session.setComplete();
		
		
		return "home";
		
	}
	@RequestMapping("/join")
	public String join(Model model) {
		System.out.println("join()");
		
		return "join";
		
	}
	
	@RequestMapping("/joinAction")
	public String joinAction(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("joinAction()");
		model.addAttribute("request", request);
		command = new UserJoinCommand();
		int result = command.execute(model);
		
		
		if(result == -2){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력이 안 된 사항이 있습니다.'); history.back();</script>");
			out.flush();
					
				}
				else {
						if(result == -1){
							System.out.println("Error : " + result );					
							response.setContentType("text/html; charset=UTF-8");
				            PrintWriter out = response.getWriter();
				            out.println("<script>alert('이미 존재하는 아이디입니다.'); history.back();</script>");
							out.flush();
				           
						}
						else {
							
							model.addAttribute("id", request.getParameter("userEmail"));
							response.setContentType("text/html; charset=UTF-8");
				            PrintWriter out = response.getWriter();
				            out.println("<script>alert('성공적으로 가입되었습니다.');location.href = 'home';</script>");
							out.flush();
							
						} 
				}
		return "home";
		
	}

}