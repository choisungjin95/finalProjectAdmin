package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.project.service.BranchService;
import com.jhta.project.service.ProposalService;
import com.jhta.project.vo.BranchVo;
import com.jhta.project.vo.ProposalVo;
import com.jtha.util.PageUtil;

@Controller
public class ProposalController {
	@Autowired
	private ProposalService proService;
	@Autowired
	private JavaMailSender mailSender;
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
			String setfrom = "maple950205@gmail.com"; //보내는 사람 이메일
		    String tomail  = "eldmsdl13@naver.com"; //받는 사람 이메일 user@gmail.com or user@naver.com
		    String title   = "메가c네마 : 문의하신 지점요청건"; //메일 제목
		    String content = "문의하신 지점오픈 요청건 **반려 되었습니다."; //메일 내용
		    try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		                          = new MimeMessageHelper(message, true, "UTF-8");
		        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
		        messageHelper.setTo(tomail);     // 받는사람 이메일
		        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
		        messageHelper.setText(content);  // 메일 내용
		        mailSender.send(message);
		      } catch(Exception e){
		        System.out.println(e);
		      }
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
	public String approveProposal(Model model, ProposalVo proVo) {
		System.out.println("승인버튼 함수 타기");
		//branchvo객체 생성하면서 파라미터로 넘어온 proVo로 각각 매게변수 슝슝 들어감
		////////insert into branch values(branchNum.nextVal,?,?,?,'영업중',sysdate)
		BranchVo brVo=new BranchVo(0, proVo.getProNum(), proVo.getProAddr(), proVo.getMemberId(), null, null);
		System.out.println("여기까지111111"+brVo);
		System.out.println("코코 왜안타"+proVo);
		int updateNum=proService.approveProposal(proVo,brVo);
		String setfrom = "maple950205@gmail.com"; //보내는 사람 이메일
	    String tomail  = "eldmsdl13@naver.com"; //받는 사람 이메일 user@gmail.com or user@naver.com
	    String title   = "메가c네마 : 문의하신 지점요청건"; //메일 제목
	    String content = "문의하신 지점오픈 요청건 **승인 되었습니다"; //메일 내용
	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	                          = new MimeMessageHelper(message, true, "UTF-8");
	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용
	        mailSender.send(message);
	      } catch(Exception e){
	        System.out.println(e);
	      }
		System.out.println(updateNum+"인트에 뭐가 담겼냐ㅐ");
		System.out.println("22222");
		if(updateNum<1) {
			return "error";
		}else {
			
			model.addAttribute("proVo", proVo);
			// 게시판 상세에서 다음글 불러오기
			ProposalVo nextVo = proService.getNextTitle(proVo.getProNum());
			model.addAttribute("nextVo", nextVo);
			// 게시판 상세에서 이전글 불러오기
			ProposalVo preVo = proService.getPreTitle(proVo.getProNum());
			model.addAttribute("preVo", preVo);

			
			
			return ".proposal.proBoardDetail";
		}
	}
}
