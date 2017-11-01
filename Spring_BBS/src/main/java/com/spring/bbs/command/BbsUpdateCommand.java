package com.spring.bbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;

public class BbsUpdateCommand implements BbsCommand {

	private String userEmail = null;//session value
	private int bbsID = 0;
	
	public BbsUpdateCommand(String userEmail, int bbsID){
		this.userEmail = userEmail;
		this.bbsID = bbsID;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		System.out.println("Session : " + userEmail);
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");
		String bbsEmail = request.getParameter("bbsEmail");//bbs userEmail
		
		
		//System.out.println(bbsContent);
		System.out.println("userEmail : "+userEmail+" "+"bbsEmail : "+ bbsEmail);
		
		if(userEmail.equals(bbsEmail)){	
			System.out.println("EQUAL");
			BbsDAO bbs = new BbsDAO();
			bbs.update( bbsID, bbsTitle, bbsContent);
		}

	}

}
