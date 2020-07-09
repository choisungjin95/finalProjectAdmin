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
import com.jhta.project.service.MembershipServcie;
import com.jhta.project.service.ProposalService;
import com.jhta.project.vo.BranchVo;
import com.jhta.project.vo.MembershipVo;
import com.jhta.project.vo.ProposalVo;
import com.jtha.util.PageUtil;

@Controller
public class ProposalController {
	@Autowired
	private ProposalService proService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MembershipServcie memberService;
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
	//�Խ��� ��Ͽ��� ���� ��ư ������ �� �� �󼼺��� ���� �Լ�
	@RequestMapping("/proposal/proBoardDetail")
	public String proBoardDetail(Model model, int proNum) {
		ProposalVo proVo = proService.getinfo(proNum);
		model.addAttribute("proVo", proVo);

		// �Խ��� �󼼿��� ������ �ҷ�����
		ProposalVo nextVo = proService.getNextTitle(proNum);
		model.addAttribute("nextVo", nextVo);
		// �Խ��� �󼼿��� ������ �ҷ�����
		ProposalVo preVo = proService.getPreTitle(proNum);
		model.addAttribute("preVo", preVo);
		return ".proposal.proBoardDetail";
	}

	// �Խ��� �󼼿��� �ݷ� Ŭ������ �� ����Ǵ� �Լ�
	@RequestMapping("/proposal/rejected")
	public String rejectProposal(Model model, int proNum) {
		int updateNum = proService.rejectProposal(proNum);
		if(updateNum<1) {
			
			return "error";
		}else {
			ProposalVo proVo = proService.getinfo(proNum);
			model.addAttribute("proVo", proVo);
			// �Խ��� �󼼿��� ������ �ҷ�����
			ProposalVo nextVo = proService.getNextTitle(proNum);
			model.addAttribute("nextVo", nextVo);
			// �Խ��� �󼼿��� ������ �ҷ�����
			ProposalVo preVo = proService.getPreTitle(proNum);
			model.addAttribute("preVo", preVo);
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
	//�Խ��� �󼼿��� ���� Ŭ������ �� ����Ǵ� �Լ�
	@RequestMapping("/proposal/approved")
	public String approveProposal(Model model, ProposalVo proVo) {
		System.out.println("���ι�ư �Լ� Ÿ��");
		BranchVo brVo=new BranchVo(0, proVo.getProNum(), proVo.getProAddr(), proVo.getMemberId(), null, null);
		System.out.println("�������111111"+brVo);
		System.out.println("���� �־�Ÿ"+proVo);
		//MembershipVo memberVo = new MembershipVo(0, null, proVo.getMemberId(), null, null, null, null, null, null, 0);
		//memberVo.getEmail();
		String email =memberService.getEmail(brVo.getMemId());
		System.out.println("email�̳�:"+email);
		int updateNum=proService.approveProposal(proVo,brVo);
		System.out.println(updateNum+"��Ʈ�� ���� ���Ĥ�");
		System.out.println("22222");
		if(updateNum<1) {
			return "error";
		}else {
			System.out.println("else���� Ÿ��??????????????????");
			
			//model.addAttribute("proVo", proVo);
			ProposalVo newProVo =proService.getinfo(proVo.getProNum());
			model.addAttribute("proVo", newProVo);
			// �Խ��� �󼼿��� ������ �ҷ�����
			ProposalVo nextVo = proService.getNextTitle(newProVo.getProNum());
			model.addAttribute("nextVo", nextVo);
			// �Խ��� �󼼿��� ������ �ҷ�����
			ProposalVo preVo = proService.getPreTitle(newProVo.getProNum());
			model.addAttribute("preVo", preVo);
			String setfrom = "maple950205@gmail.com"; //������ ��� �̸���
		    String tomail  = "eldmsdl13@naver.com"; //�޴� ��� �̸��� user@gmail.com or user@naver.com
		    String title   = "�ް�c�׸� : �����Ͻ� ������û��"; //���� ����
		    String content = "�����Ͻ� �������� ��û�� **���� �Ǿ����ϴ�"; //���� ����
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
}
