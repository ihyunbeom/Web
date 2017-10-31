package com.spring.bbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;


public class BbsWriteCommand implements BbsCommand {

	private String userEmail = null;
	
	public BbsWriteCommand(String userEmail){
		this.userEmail = userEmail;
		
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		System.out.println("Session : " + userEmail);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");
			
		
		BbsDAO bbs = new BbsDAO();
		bbs.write( bbsTitle, userEmail, bbsContent);

	}

}
