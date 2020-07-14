package com.jhta.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.ApproveProposalVo;
import com.jhta.project.vo.BranchVo;
import com.jhta.project.vo.ProposalVo;

@Controller
public class ProposalController {
	
	@Autowired
	private RestService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/proposal/brManagement")
	public String proposalBoard(Model model, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/proposal/brManagement/totalRowNum";
		String stotalRowNum=service.get(url).trim();
		int totalRowNum=Integer.parseInt(stotalRowNum);
		PageUtil pu=new PageUtil(pageNum, totalRowNum, 5, 5);
		System.out.println("페이지 수는"+pu.getTotalPageCount());
		HashMap<String, Object>  map= new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		String url1="http://localhost:9090/projectdb/proposal/brManagement";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(map);
		String code=service.post(url1, jsonString).trim();
		System.out.println("code:"+code);
		Gson gson=new Gson();
		ProposalVo[] array=gson.fromJson(code, ProposalVo[].class);
		List<ProposalVo> list=Arrays.asList(array);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		return ".proposal.proBoard";
	}
	
	@RequestMapping("/proposal/proBoardDetail")
	public String proBoardDetail(Model model, int proNum) {
		String url="http://localhost:9090/projectdb/proposal/proBoardDetail/proGetinfo?proNum="+proNum;
		String sproVo=service.get(url).trim();
		Gson gson=new Gson();
		ProposalVo proVo=gson.fromJson(sproVo, ProposalVo.class);
		model.addAttribute("proVo",proVo);
		String url1="http://localhost:9090/projectdb/proposal/proBoardDetail/nextPro?proNum="+proNum;
		String snextVo=service.get(url1).trim();
		ProposalVo nextVo=gson.fromJson(snextVo, ProposalVo.class);
		model.addAttribute("proVo",proVo);
		model.addAttribute("nextVo",nextVo);
		String url2="http://localhost:9090/projectdb/proposal/proBoardDetail/prePro?proNum="+proNum;
		String spreVo=service.get(url2).trim();
		ProposalVo preVo=gson.fromJson(spreVo, ProposalVo.class);
		model.addAttribute("proVo",proVo);
		model.addAttribute("nextVo",nextVo);
		model.addAttribute("preVo",preVo);
		return ".proposal.proBoardDetail";
	}
	
	@RequestMapping("/proposal/rejected")
	public String rejectProposal(Model model, int proNum) {
		String urlUpdate="http://localhost:9090/projectdb/proposal/rejectProposal?proNum="+proNum;
		String sUpdateNum=service.get(urlUpdate).trim();
		int updateNum=Integer.parseInt(sUpdateNum);
		if(updateNum<1) {
			return "error";
		}else {
			String url="http://localhost:9090/projectdb/proposal/proBoardDetail/proGetinfo?proNum="+proNum;
			String sproVo=service.get(url).trim();
			Gson gson=new Gson();
			ProposalVo proVo=gson.fromJson(sproVo, ProposalVo.class);
			model.addAttribute("proVo",proVo);
			String url1="http://localhost:9090/projectdb/proposal/proBoardDetail/nextPro?proNum="+proNum;
			String snextVo=service.get(url1).trim();
			ProposalVo nextVo=gson.fromJson(snextVo, ProposalVo.class);
			model.addAttribute("proVo",proVo);
			model.addAttribute("nextVo",nextVo);
			String url2="http://localhost:9090/projectdb/proposal/proBoardDetail/prePro?proNum="+proNum;
			String spreVo=service.get(url2).trim();
			ProposalVo preVo=gson.fromJson(spreVo, ProposalVo.class);
			model.addAttribute("proVo",proVo);
			model.addAttribute("nextVo",nextVo);
			model.addAttribute("preVo",preVo);
			String setfrom = "maple950205@gmail.com"; //������ ��� �̸���
		    String tomail  = "eldmsdl13@naver.com"; //�޴� ��� �̸��� user@gmail.com or user@naver.com
		    String title   = "�ް�c�׸� : �����Ͻ� ������û��"; //���� ����
		    String content = "�����Ͻ� �������� ��û�� **�ݷ� �Ǿ����ϴ�."; //���� ����
		    try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		                          = new MimeMessageHelper(message, true, "UTF-8");
		        messageHelper.setFrom(setfrom);  // �����»�� �����ϰų� �ϸ� �����۵��� ����
		        messageHelper.setTo(tomail);     // �޴»�� �̸���
		        messageHelper.setSubject(title); // ���������� ������ �����ϴ�
		        messageHelper.setText(content);  // ���� ����
		        mailSender.send(message);
		      } catch(Exception e){
		        System.out.println(e);
		      }
			return ".proposal.proBoardDetail";
		}
	}
	
	@RequestMapping("/proposal/approved")
	public String approveProposal(Model model, ProposalVo proVo) {
		BranchVo brVo=new BranchVo(0, proVo.getProNum(), proVo.getProAddr(), proVo.getMemberId(), null, null);
		String urlEmail="http://localhost:9090/projectdb/proposal/approved/email?memId="+brVo.getMemId();
		String semail=service.get(urlEmail).trim();
		Gson gson=new Gson();
		String email=gson.fromJson(semail, String.class);
		String urlApprove="http://localhost:9090/projectdb/proposal/approved";
		ApproveProposalVo appVo=new ApproveProposalVo(proVo, brVo);
		String jsonString=gson.toJson(appVo,ApproveProposalVo.class);
		String supdateNum=service.post(urlApprove, jsonString).trim();
		int updateNum=Integer.parseInt(supdateNum);
		if(updateNum<1) {
			return "error";
		}else {
			String url="http://localhost:9090/projectdb/proposal/proBoardDetail/proGetinfo?proNum="+proVo.getProNum();
			String sproVo=service.get(url).trim();
			ProposalVo proVo1=gson.fromJson(sproVo, ProposalVo.class);
			String url1="http://localhost:9090/projectdb/proposal/proBoardDetail/nextPro?proNum="+proVo.getProNum();
			String snextVo=service.get(url1).trim();
			ProposalVo nextVo=gson.fromJson(snextVo, ProposalVo.class);
			String url2="http://localhost:9090/projectdb/proposal/proBoardDetail/prePro?proNum="+proVo.getProNum();
			String spreVo=service.get(url2).trim();
			ProposalVo preVo=gson.fromJson(spreVo, ProposalVo.class);
			model.addAttribute("proVo",proVo1);
			model.addAttribute("nextVo",nextVo);
			model.addAttribute("preVo",preVo);
			String setfrom = "maple950205@gmail.com";
		    String tomail  = "eldmsdl13@naver.com";
		    String title   = "�ް�c�׸� : �����Ͻ� ������û��";
		    String content = "�����Ͻ� �������� ��û�� **���� �Ǿ����ϴ�";
		    try {
		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper messageHelper 
		                          = new MimeMessageHelper(message, true, "UTF-8");
		        messageHelper.setFrom(setfrom);
		        messageHelper.setTo(tomail);   
		        messageHelper.setSubject(title);
		        messageHelper.setText(content);
		        mailSender.send(message);
		      } catch(Exception e){
		        System.out.println(e);
		      }
			return ".proposal.proBoardDetail";
		}
	}
	
}
