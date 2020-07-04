package com.jhta.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jhta.page.util.PageUtil;
import com.jhta.project.service.QnaService;
import com.jhta.project.vo.QnaVo;

@Controller
public class ServiceController {
	@Autowired
	private QnaService qnaService;
	
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
}

