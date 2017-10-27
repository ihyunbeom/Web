package com.spring.bbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;

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
		
		System.out.println("(Command)BbsTitle : " + bbsDTO.getBbsTitle());
		
		model.addAttribute("view",bbsDTO);
		
	}

}
