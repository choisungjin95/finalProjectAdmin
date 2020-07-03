package com.jhta.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.ProposalService;
import com.jhta.project.vo.ProposalVo;

@Controller
public class ProposalController {
	@Autowired
	private ProposalService proService;
	@RequestMapping("/proposal/brManagement")
	public String proposalBoard(Model model) {
		List<ProposalVo> list=proService.selectList();
		model.addAttribute("list",list);
		System.out.println("con:"+list);
		return ".proposal.proBoard";
		
	}
}
