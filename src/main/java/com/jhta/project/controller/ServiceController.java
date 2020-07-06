package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.page.util.PageUtil;
import com.jhta.project.service.AskServiceTr;
import com.jhta.project.service.AskService;
import com.jhta.project.service.AskServiceImpl;
import com.jhta.project.service.QnaService;
import com.jhta.project.vo.AskVo;
import com.jhta.project.vo.QnaVo;
import com.jhta.project.vo.ReplyVo;

@Controller
public class ServiceController {
	@Autowired
	private QnaService qnaService;
	@Autowired
	private AskServiceTr askServiceTr;
	@Autowired
	private AskService askService;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping("/service/service.do")
	public String service() {
		return ".service.service";
	}
	
	@RequestMapping("/service/qna/insert.do")
	public String qnaInsert() {
		return ".service.qna.insert";
	}
	
	@RequestMapping("/service/qna/update.do")
	public String qnaUpdate(Model model,int qnaNum) {
		model.addAttribute("vo",qnaService.getinfo(qnaNum));
		return ".service.qna.update";
	}
	
	
	@RequestMapping("/service/qna/updateOk.do")
	public String qnaUpdateOk(QnaVo vo) {
		int n=qnaService.update(vo);
		if(n>0) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/service/qna/delete.do")
	public String qnaDelete(Model model,int qnaNum) {
		int n=qnaService.delete(qnaNum);
		if(n>0) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/service/qna/list.do")
	public String qnaList(Model model,@RequestParam(value="pageNum",defaultValue = "1")int pageNum) {
		int totalRowCount= qnaService.count();
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<QnaVo> list=qnaService.list(map);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		return ".service.qna.list";
	}
	
	@RequestMapping("/service/qna/insertOk.do")
	public String qnaInsertOk(QnaVo vo) {
		int n=qnaService.insert(vo);
		if(n>0) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	//질문 목록(성진)
	@RequestMapping("/service/reply/askList.do")
	public String askList(@RequestParam(value="pageNum",defaultValue = "1")int pageNum,Model model) {
		int totalRowCount= askService.count();
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		List<AskVo> list=askService.list(map);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		return ".service.reply.reply";
	}
	//질문 자세히 보기(성진)
	@RequestMapping("/service/reply/getinfo.do")
	public String getInfo(int askNum,Model model) {
		AskVo vo=askService.askGetinfo(askNum);
		ReplyVo vo1=askService.replyGetinfo(askNum);
		
		System.out.println(vo+"vo");
		System.out.println(vo1+"vo1");
		
		model.addAttribute("vo", vo);
		model.addAttribute("vo1", vo1);
		return ".service.reply.getinfo";
	}
	//질문 답변하기(성진)
	@RequestMapping("/service/reply/insert.do")
	public String replyInsert(ReplyVo vo,HttpServletRequest request){
		
		int n=askServiceTr.replyInsert(vo);
		AskVo vo1=askService.askGetinfo(vo.getAskNum());
		
		System.out.println("질문한 사람 이메일"+vo1.getEmail());
		
	    String setfrom = "test@gmail.com"; //보내는 사람 이메일
	    String tomail  = /*vo1.getEmail();*/"test@gmail.com"; //받는 사람 이메일
	    String title   = "메가c네마 : 문의하신 질문 답변완료"; //메일 제목
	    String content = "제목["+vo.getQnaTitle()+"]\n내용:"+vo.getReplyContent(); //메일 내용
	    
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
		
		return "redirect:/service/reply/askList.do";
	}
	//답변수정하기(성진)
	@RequestMapping("/service/reply/update.do")
	public String replyUpdate(ReplyVo vo) {
		int n=askService.replyUpdate(vo);
		AskVo vo1=askService.askGetinfo(vo.getAskNum());
		
		System.out.println("질문한 사람 이메일"+vo1.getEmail());
		
		String setfrom = "maple950205@gmail.com"; //보내는 사람 이메일
	    String tomail  = /*vo1.getEmail();*/"choisungjin95@gmail.com"; //받는 사람 이메일
	    String title   = "메가c네마 : 문의하신 질문 답변이 수정됬습니다"; //메일 제목
	    String content = "제목["+vo.getQnaTitle()+"]\n내용:"+vo.getReplyContent(); //메일 내용
	    
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
		
		return "redirect:/service/reply/askList.do";
	}
}

