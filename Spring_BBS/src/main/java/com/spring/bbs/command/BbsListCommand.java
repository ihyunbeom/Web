package com.spring.bbs.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;
import com.spring.bbs.dto.BbsDTO;

public class BbsListCommand implements BbsCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsDTO> dtos = dao.getList();
		model.addAttribute("list", dtos);

	}

}
