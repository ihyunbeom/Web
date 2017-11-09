package com.spring.bbs.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;
import com.spring.bbs.dto.ReplyDTO;

public class BbsReplyCommand implements BbsCommand {
	private String userEmail = null;
	private int bbsId;
	
	public BbsReplyCommand(String userEmail, int bbsId){
		this.userEmail = userEmail;
		this.bbsId = bbsId;
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		System.out.println("Session : " + userEmail);
		
		
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String replyContent = request.getParameter("replyContent");
		
		//System.out.println("Write String : " + bbsContent);
		
		BbsDAO bbs = new BbsDAO();
		bbs.reply_write( bbsId, userEmail, replyContent);

	}

}
