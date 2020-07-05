package com.jhta.project.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.project.service.FilmService;
import com.jhta.project.vo.FilmVo;

@Controller
public class IncomeController {
	@Autowired
	private FilmService service;
	
	@RequestMapping("/admin/income/moive.do")
	public String goIncomeMoive(Model model) {
		List<String> list = service.getName();
		JSONArray array = new JSONArray();
		for(String data : list) {
			JSONObject object = new JSONObject();
			object.put("data", data);
			array.put(object);
		}
		model.addAttribute("array",array);
		return ".admin.income.movie";
	}
	
	@RequestMapping("/admin/income/getChat")
	@ResponseBody
	public String getmovieChat(String filmName) {
		System.out.println(filmName);
		List<HashMap<String,Object>> list = service.getChat(filmName);
		JSONArray array = new JSONArray();
		for(HashMap<String,Object> map : list) {
			JSONObject object = new JSONObject();
			object.put("totalDate", new SimpleDateFormat("yyyy-MM-dd").format(map.get("totalDate")));
			object.put("totalPeople", map.get("totalPeople"));
			object.put("totalPrice", map.get("totalPrice"));
			array.put(object);
		}
		return array.toString();
	}
	
	@RequestMapping("/admin/income/branch.do")
	public String goIncomeBranch() {
		return ".admin.income.branch";
	}
}
