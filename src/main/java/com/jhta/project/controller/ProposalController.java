package com.jhta.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.project.service.ProposalService;
import com.jhta.project.vo.ProPagingVo;
import com.jhta.project.vo.ProposalVo;

@Controller
public class ProposalController {
	@Autowired
	private ProposalService proService;
	@RequestMapping("/proposal/brManagement")
	public String proposalBoard(Model model) {
//		List<ProposalVo> list=proService.selectList();
		
		int total=proService.totalPageNum();
		System.out.println(total);
		int nowPage = 1; // 컨트롤러에서 가져온 현재 페이지
		int perPage = 10;
		
		ProPagingVo PPageVo = new ProPagingVo(total, nowPage, perPage);
		int startPage = PPageVo.getStartPage();
		int lastPage = PPageVo.getLastPage();
		boolean nextBtn = PPageVo.getNextBtn();
		boolean preBtn = PPageVo.getPreBtn();
		
		List<ProposalVo> list=proService.getRowNums();
		model.addAttribute("list",list);
		model.addAttribute("startPage",startPage);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("nextBtn",nextBtn);
		model.addAttribute("preBtn",preBtn);
		
		System.out.println("con:"+list);
		return ".proposal.proBoard";
	}
	/*
	public List<ProposalVo> getRowNums(Model model, int startPage, int lastPage){
		List<ProposalVo> list=proService.selectList();
		model.addAttribute("list",list);
		return "list";
				
	}
	*/
}
