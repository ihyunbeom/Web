package com.spring.bbs.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;
import com.spring.bbs.dto.ReplyDTO;

public class BbsViewCommand implements BbsCommand {

	private int bbsID = 1;
	
	public BbsViewCommand(int bbsID){
		this.bbsID = bbsID;
		
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BbsDAO bbsDAO = new BbsDAO();
		BbsDTO bbsDTO = bbsDAO.getBbs(bbsID);
		
		bbsDTO.setBbsContent(bbsDTO.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\r\\n","<br>"));
		ArrayList<ReplyDTO> replyDTO = bbsDAO.getReply(bbsID);
		
		model.addAttribute("view",bbsDTO);
		model.addAttribute("reply", replyDTO);
		
	}

}
