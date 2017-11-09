package com.spring.bbs.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;

public class BbsListCommand implements BbsCommand {
	private int pageNumber = 1;
	
	public BbsListCommand(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BbsDAO bbsDAO = new BbsDAO();
		ArrayList<BbsDTO> bbsDTO = bbsDAO.getList(pageNumber);
		
		
		model.addAttribute("list", bbsDTO);
		model.addAttribute("pageNumber", pageNumber);
		
		if(bbsDAO.nextPage(pageNumber + 1))
			model.addAttribute("nextPage", pageNumber+1);
		else
			model.addAttribute("nextPage", pageNumber);
		

	}

}
