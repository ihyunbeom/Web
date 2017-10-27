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
			
			model.addAttribute("id", request.getParameter("userEmail"));
	        
			return "home";
			
		}
		else if(result == 0){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('��й�ȣ�� Ȯ���ϼ���.');history.back();</script>");
			out.flush();
			return "login";
		}
		else if(result == -1){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�������� �ʴ� ���̵��Դϴ�.');history.back();</script>");
			out.flush();
			return "login";
		}
		else if(result == -2){
			System.out.println("Error : " + result );
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�����ͺ��̽� ������ �߻��߽��ϴ�.');history.back();</script>");
			out.flush();
			return "login";
		}
		
		return "redirect:/home";
		
	}
	
	@RequestMapping("/logoutAction")
	public String logoutAction(Model model, SessionStatus session) {
		System.out.println("logoutAction()");
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
			out.println("<script>alert('�Է��� �� �� ������ �ֽ��ϴ�.'); history.back();</script>");
			out.flush();
					
				}
				else {
						if(result == -1){
							System.out.println("Error : " + result );					
							response.setContentType("text/html; charset=UTF-8");
				            PrintWriter out = response.getWriter();
				            out.println("<script>alert('�̹� �����ϴ� ���̵��Դϴ�.'); history.back();</script>");
							out.flush();
				           
						}
						else {
							
							model.addAttribute("id", request.getParameter("userEmail"));
							response.setContentType("text/html; charset=UTF-8");
				            PrintWriter out = response.getWriter();
				            out.println("<script>alert('���������� ���ԵǾ����ϴ�.');location.href = 'home';</script>");
							out.flush();
							
						} 
				}
		return "home";
		
	}

}
