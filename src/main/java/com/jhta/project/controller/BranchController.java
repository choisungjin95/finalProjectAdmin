package com.jhta.project.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jhta.project.service.BranchService;
import com.jhta.project.vo.BranchVo;
import com.jtha.util.PageUtil;

@Controller
public class BranchController {
	@Autowired
	private BranchService service;
	
	@RequestMapping("/branch.do")
	public ModelAndView list(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String keyword) {
		ModelAndView mv=new ModelAndView(".branch.branch");
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		int totalRowCount=service.count(map); //ÀüÃ¼±Û°¹¼ö
		PageUtil pu=new PageUtil(pageNum, totalRowCount,50,10);
		System.out.println(pageNum);
		System.out.println(totalRowCount);
		map.put("startRow", pu.getStartRow());
		System.out.println(pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		System.out.println(pu.getEndRow());
		List<BranchVo> list=service.list(map);
		mv.addObject("list",list);
		mv.addObject("pu",pu);
		mv.addObject("keyword",keyword);
		return mv;
	}
	
}
