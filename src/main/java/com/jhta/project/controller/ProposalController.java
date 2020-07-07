package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.ProposalService;
import com.jhta.project.vo.ProposalVo;
import com.jtha.util.PageUtil;

@Controller
public class ProposalController {
	@Autowired
	private ProposalService proService;

	@RequestMapping("/proposal/brManagement")
	public String proposalBoard(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
//		List<ProposalVo> list=proService.selectList();

		int totalRowNum = proService.totalRowNum();
		PageUtil pu = new PageUtil(pageNum, totalRowNum, 5, 5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());

		List<ProposalVo> list = proService.getRowNums(map);
		model.addAttribute("list", list);
		model.addAttribute("pu", pu);
		return ".proposal.proBoard";
	}
	//게시판 목록에서 지점 버튼 눌렀을 때 글 상세보기 실행 함수
	@RequestMapping("/proposal/proBoardDetail")
	public String proBoardDetail(Model model, int proNum) {
		ProposalVo proVo = proService.getinfo(proNum);
		model.addAttribute("proVo", proVo);

		// 게시판 상세에서 다음글 불러오기
		ProposalVo nextVo = proService.getNextTitle(proNum);
		model.addAttribute("nextVo", nextVo);
		// 게시판 상세에서 이전글 불러오기
		ProposalVo preVo = proService.getPreTitle(proNum);
		model.addAttribute("preVo", preVo);
		return ".proposal.proBoardDetail";
	}

	// 게시판 상세에서 반려 클릭했을 때 실행되는 함수
	@RequestMapping("/proposal/rejected")
	public String rejectProposal(Model model, int proNum) {
		int updateNum = proService.rejectProposal(proNum);
		if(updateNum<1) {
			return "error";
		}else {
			ProposalVo proVo = proService.getinfo(proNum);
			model.addAttribute("proVo", proVo);
			// 게시판 상세에서 다음글 불러오기
			ProposalVo nextVo = proService.getNextTitle(proNum);
			model.addAttribute("nextVo", nextVo);
			// 게시판 상세에서 이전글 불러오기
			ProposalVo preVo = proService.getPreTitle(proNum);
			model.addAttribute("preVo", preVo);
			return ".proposal.proBoardDetail";
		}
	}
	
	//게시판 상세에서 승인 클릭했을 때 실행되는 함수
	@RequestMapping("/proposal/approved")
	public String approveProposal(Model model, int proNum) {
		System.out.println("승인버튼 함수 타기");
		int updateNum=proService.approveProposal(proNum);
		if(updateNum<1) {
			return "error";
		}else {
			ProposalVo proVo = proService.getinfo(proNum);
			model.addAttribute("proVo", proVo);
			// 게시판 상세에서 다음글 불러오기
			ProposalVo nextVo = proService.getNextTitle(proNum);
			model.addAttribute("nextVo", nextVo);
			// 게시판 상세에서 이전글 불러오기
			ProposalVo preVo = proService.getPreTitle(proNum);
			model.addAttribute("preVo", preVo);
			return ".proposal.proBoardDetail";
		}
	}
}
