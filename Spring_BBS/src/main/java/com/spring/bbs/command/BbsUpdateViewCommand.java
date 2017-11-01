package com.spring.bbs.command;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;

public class BbsUpdateViewCommand implements BbsCommand {

	private int bbsID = 1;
	
	public BbsUpdateViewCommand(int bbsID){
		this.bbsID = bbsID;
		
	}
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BbsDAO bbsDAO = new BbsDAO();
		BbsDTO bbsDTO = bbsDAO.getBbs(bbsID);
		
		//System.out.println("(Command)BbsTitle : " + bbsDTO.getBbsTitle());
		//bbsDTO.setBbsContent(bbsDTO.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\r\\n","<br>"));
		//System.out.println(bbsDTO.getBbsContent());
		model.addAttribute("view",bbsDTO);
		
	}

}
