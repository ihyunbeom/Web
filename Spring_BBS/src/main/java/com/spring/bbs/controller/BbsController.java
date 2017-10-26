package com.spring.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bbs.command.BbsCommand;
import com.spring.bbs.command.BbsListCommand;
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
		command = new BbsListCommand();
		command.execute(model);
		
		return "write";
	}
	
	@RequestMapping("/writeAction")
	public String writeAction(Model model) {
		System.out.println("writeAction()");
		command = new BbsWriteCommand();
		command.execute(model);
		
		return "redirect:/list";
	}
	
}
