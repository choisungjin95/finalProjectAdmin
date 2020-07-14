package com.jhta.project.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.jhta.page.util.PageUtil;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.BranchVo;

@Controller
public class BranchController {
	@Autowired
	private RestService service;
	
	@RequestMapping("/branch.do")
	public String list(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String keyword,Model model) {
		String urlCount="http://localhost:9090/projectdb/branch/count.do?keyword="+keyword;
		String sCount=service.get(urlCount).trim();
		int totalRowCount=Integer.parseInt(sCount);
		PageUtil pu=new PageUtil(pageNum, totalRowCount,50,10);
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		String urlBranch="http://localhost:9090/projectdb/branch.do";
		Gson gson=new Gson();
		String jsonString=gson.toJson(map);
		String code=service.post(urlBranch, jsonString).trim();
		BranchVo[] array= gson.fromJson(code, BranchVo[].class);
		List<BranchVo> list=Arrays.asList(array);
		model.addAttribute("list",list);
		model.addAttribute("pu",pu);
		model.addAttribute("keyword",keyword);
		return ".branch.branch";
	}
	
}
