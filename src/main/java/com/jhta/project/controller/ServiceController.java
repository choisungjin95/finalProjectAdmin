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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.AskService;
import com.jhta.project.service.AskServiceTr;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.AskVo;
import com.jhta.project.vo.QnaVo;
import com.jhta.project.vo.ReplayInfoVo;
import com.jhta.project.vo.ReplyVo;

@Controller
public class ServiceController {
	@Autowired
	private RestService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private AskServiceTr askServiceTr;
	
	@Autowired
	private AskService askService;

	@RequestMapping("/service/service.do")
	public String service() {
		return ".service.service";
	}
	
	@RequestMapping("/service/qna/insert.do")
	public String qnaInsert() {
		return ".service.qna.insert";
	}
	
	@RequestMapping(value="/service/qna/insertOk.do",method=RequestMethod.POST)
	public String qnaInsertOk(QnaVo vo) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/service/qna/insertOk.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(url,jsonString).trim();
		if(code.equals("success")) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value="/service/qna/update.do",method = RequestMethod.GET)
	public String qnaUpdate(Model model,int qnaNum) {
		String url = "http://localhost:9090/projectdb/service/qna/update.do?qnaNum="+qnaNum;
		String code=service.get(url).trim();
		Gson gson=new Gson();
		QnaVo vo=gson.fromJson(code, QnaVo.class);
		model.addAttribute("vo",vo);
		return ".service.qna.update";
	}
	
	@RequestMapping(value="/service/qna/updateOk.do",method=RequestMethod.POST)
	public String qnaUpdateOk(QnaVo vo) throws JsonProcessingException {
		String url="http://localhost:9090/projectdb/service/qna/updateOk.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(url,jsonString).trim();
		if(code.equals("success")) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value="/service/qna/delete.do",method = RequestMethod.GET)
	public String qnaDelete(Model model,int qnaNum) {
		String url = "http://localhost:9090/projectdb/service/qna/delete.do?qnaNum="+qnaNum;
		String code=service.get(url).trim();
		if(code.equals("success")) {
			return "redirect:/service/qna/list.do";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value="/service/qna/list.do",method=RequestMethod.GET)
	public String qnaList(Model model,@RequestParam(value="pageNum",defaultValue = "1")int pageNum) throws JsonProcessingException {
		String urlCount="http://localhost:9090/projectdb/service/qna/count.do?pageNum="+pageNum;
		String scount=service.get(urlCount).trim();
		int totalRowCount=Integer.parseInt(scount);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		String url="http://localhost:9090/projectdb/service/qna/list.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(map);
		String slist = service.post(url, jsonString).trim();
		Gson gson=new Gson();
		QnaVo[] array=gson.fromJson(slist, QnaVo[].class);
		List<QnaVo> list=Arrays.asList(array);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		return ".service.qna.list";
	}
	
	
	
	//질문 목록(성진)
	@RequestMapping(value="/service/reply/askList.do",method=RequestMethod.GET)
	public String askList(@RequestParam(value="pageNum",defaultValue = "1")int pageNum,Model model) throws JsonProcessingException {
		String urlCount="http://localhost:9090/projectdb/service/reply/count.do";
		String scount=service.get(urlCount).trim();
		int totalRowCount=Integer.parseInt(scount);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		String url="http://localhost:9090/projectdb/service/reply/askList.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(map);
		String slist = service.post(url, jsonString).trim();
		Gson gson=new Gson();
		AskVo[] array=gson.fromJson(slist, AskVo[].class);
		List<AskVo> list=Arrays.asList(array);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		System.out.println(slist);
		return ".service.reply.reply";
	}
	
	//질문 자세히 보기(성진)
	@RequestMapping(value="/service/reply/getinfo.do",method=RequestMethod.GET)
	public String getInfo(int askNum,Model model) {
		String url = "http://localhost:9090/projectdb/service/reply/getinfo.do?askNum="+askNum;
		String code=service.get(url).trim();
		Gson gson=new Gson();
		ReplayInfoVo rvo=gson.fromJson(code, ReplayInfoVo.class);
		if(rvo.getVo1()!=null) {
			ReplyVo vo1= rvo.getVo1();
			model.addAttribute("vo1", vo1);
		}
		model.addAttribute("vo", rvo.getVo());
		return ".service.reply.getinfo";
	}
	
	
	//질문 답변하기(성진)
	@RequestMapping(value="/service/reply/insert.do",method=RequestMethod.POST)
	public String replyInsert(ReplyVo vo) throws JsonProcessingException{
		String url="http://localhost:9090/projectdb/service/reply/insert.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(url,jsonString).trim();
		if(code.equals("null")) {
			return "error";
		}else {
			Gson gson=new Gson();
			AskVo vo1= gson.fromJson(code, AskVo.class);
		    String setfrom = "maple950205@gmail.com"; //보내는 사람 이메일
		    String tomail  = vo1.getEmail(); //받는 사람 이메일 user@gmail.com or user@naver.com
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
	}
	
	//답변수정하기(성진)
	@RequestMapping(value="/service/reply/update.do",method=RequestMethod.POST)
	public String replyUpdate(ReplyVo vo) throws JsonProcessingException {
		System.out.println("vo------------"+vo);
		String url="http://localhost:9090/projectdb/service/reply/update.do";
		ObjectMapper mapper=new ObjectMapper();
		String jsonString= mapper.writeValueAsString(vo);
		String code=service.post(url,jsonString).trim();
		
		if(code.equals("null")) {
			return "error";
		}else {
			Gson gson=new Gson();
			AskVo vo1= gson.fromJson(code, AskVo.class);
			
			String setfrom = "maple950205@gmail.com"; //보내는 사람 이메일
		    String tomail  = "choisungjin95@gmail.com"; //받는 사람 이메일
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
}

