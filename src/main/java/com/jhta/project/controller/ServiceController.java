package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.page.util.PageUtil;
import com.jhta.project.service.AskService;
import com.jhta.project.service.QnaService;
import com.jhta.project.vo.AskVo;
import com.jhta.project.vo.QnaVo;
import com.jhta.project.vo.ReplyVo;

@Controller
public class ServiceController {
	@Autowired
	private QnaService qnaService;
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
		model.addAttribute("vo", vo);
		model.addAttribute("vo1", vo1);
		return ".service.reply.getinfo";
	}
	//질문 답변하기(성진)
	@RequestMapping("/service/reply/insert.do")
	public String replyInsert(ReplyVo vo) throws Exception {
		
		int n=askService.replyInsert(vo);
		int n1=askService.respUpdate(vo.getAskNum());
		
		
		return "redirect:/service/reply/askList.do";
	}
	//답변수정하기(성진)
	@RequestMapping("/service/reply/update.do")
	public String replyUpdate(ReplyVo vo) {
		int n=askService.replyUpdate(vo);
		return "redirect:/service/reply/askList.do";
	}
}

