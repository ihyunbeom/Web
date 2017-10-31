package com.spring.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.bbs.command.BbsCommand;
import com.spring.bbs.command.BbsDeleteCommand;
import com.spring.bbs.command.BbsListCommand;
import com.spring.bbs.command.BbsUpdateCommand;
import com.spring.bbs.command.BbsViewCommand;
import com.spring.bbs.command.BbsWriteCommand;


@Controller
public class BbsController {

	BbsCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BbsListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write")
	public String write(Model model) {
		System.out.println("write()");
		
		return "write";
	}
	
	@RequestMapping("/writeAction")
	public String writeAction(HttpServletRequest request, Model model) {
		System.out.println("writeAction()");
		HttpSession ses=request.getSession();
		
		model.addAttribute("request", request);
		command = new BbsWriteCommand(ses.getAttribute("id").toString());
		command.execute(model);
		
		
		return "redirect:/list";
	}
	
	@RequestMapping("/view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("view()");
		
		HttpSession ses=request.getSession();
		model.addAttribute("request", request);
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
		
		command = new BbsViewCommand(bbsID);
		command.execute(model);
		
		return "view";
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		System.out.println("update()");
		
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
		model.addAttribute("request", request);
		System.out.println("BbsID : " + bbsID);
		command = new BbsViewCommand(bbsID);
		command.execute(model);
		
		
		return "update";
	}
	
	@RequestMapping(value="/updateAction", method=RequestMethod.POST )
	public String updateAction(HttpServletRequest request, Model model){
		System.out.println("updateAction()");
		
		HttpSession ses=request.getSession();
		
		model.addAttribute("request", request);
		int bbsID = Integer.parseInt(request.getParameter("bbsID"));
		System.out.println("[updateAction] id : " + ses.getAttribute("id").toString()+" bbsID : " + bbsID);

		command = new BbsUpdateCommand(ses.getAttribute("id").toString(), bbsID);
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BbsDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
