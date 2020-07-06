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

import com.jhta.project.service.BranchService;
import com.jhta.project.service.FilmService;
import com.jhta.project.vo.FilmVo;

@Controller
public class IncomeController {
	@Autowired
	private FilmService filmService;
	@Autowired
	private BranchService branchService;
	
	@RequestMapping("/admin/income/branch.do")
	public String goIncomeBranch(Model model) {
		List<String> branchList = branchService.getName();
		List<String> filmList = filmService.getName();
		JSONArray branchArray = new JSONArray();
		JSONArray filmArray = new JSONArray();
		for(String data : branchList) {
			JSONObject object = new JSONObject();
			object.put("data", data);
			branchArray.put(object);
		}
		for(String data : filmList) {
			JSONObject object = new JSONObject();
			object.put("data", data);
			filmArray.put(object);
		}
		model.addAttribute("branchArray",branchArray);
		model.addAttribute("filmArray",filmArray);
		return ".admin.income.branch";
	}
	
	@RequestMapping("/admin/income/moive.do")
	public String goIncomeMoive(Model model) {
		List<String> branchList = branchService.getName();
		List<String> filmList = filmService.getName();
		JSONArray branchArray = new JSONArray();
		JSONArray filmArray = new JSONArray();
		for(String data : branchList) {
			JSONObject object = new JSONObject();
			object.put("data", data);
			branchArray.put(object);
		}
		for(String data : filmList) {
			JSONObject object = new JSONObject();
			object.put("data", data);
			filmArray.put(object);
		}
		model.addAttribute("branchArray",branchArray);
		model.addAttribute("filmArray",filmArray);
		return ".admin.income.movie";
	}
	
	@RequestMapping("/admin/income/getChat")
	@ResponseBody
	public String getmovieChat(String filmName) {
		List<HashMap<String,Object>> list = filmService.getChat(filmName);
		JSONArray array = new JSONArray();
		for(HashMap<String,Object> map : list) {
			JSONObject object = new JSONObject();
			object.put("totalDate", new SimpleDateFormat("yyyy-MM-dd").format(map.get("totalDate")));
			object.put("totalPeople", map.get("totalPeople"));
			object.put("totalPrice", map.get("totalPrice"));
			object.put("filmPrice", map.get("filmPrice"));
			array.put(object);
		}
		return array.toString();
	}
	
	@RequestMapping("/admin/income/getBranchChat")
	@ResponseBody
	public String getBranchChat(String filmName) {
		List<HashMap<String,Object>> list = branchService.getChat(filmName);
		JSONArray array = new JSONArray();
		for(HashMap<String,Object> map : list) {
			JSONObject object = new JSONObject();
			object.put("revenueDate", new SimpleDateFormat("yyyy-MM-dd").format(map.get("revenueDate")));
			object.put("ticketIncome", map.get("ticketIncome"));
			object.put("storeIncome", map.get("storeIncome"));
			object.put("outcome", map.get("outcome"));
			array.put(object);
		}
		return array.toString();
	}
}
