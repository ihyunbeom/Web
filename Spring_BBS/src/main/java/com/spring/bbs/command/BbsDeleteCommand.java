package com.spring.bbs.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.bbs.dao.BbsDAO;


public class BbsDeleteCommand implements BbsCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bbsID = request.getParameter("bbsID");
		BbsDAO bbsDAO = new BbsDAO();
		bbsDAO.delete(bbsID);

	}

}
