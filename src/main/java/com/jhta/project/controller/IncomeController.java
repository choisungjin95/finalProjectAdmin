package com.jhta.project.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jhta.project.service.RestService;

@Controller
public class IncomeController {
	@Autowired
	private RestService service;
	
	@RequestMapping(value="/admin/income/branch.do",method=RequestMethod.GET)
	public String goIncomeBranch(Model model) {
		String branchUrl ="http://localhost:9090/projectdb/admin/income/branch.do";
		String sbranch = service.get(branchUrl).trim();
		String filmUrl = "http://localhost:9090/projectdb/admin/income/film.do";
		String fbranch = service.get(filmUrl).trim();
		Gson gson=new Gson();
		String[] array=gson.fromJson(sbranch, String[].class);
		List<String> branchList=Arrays.asList(array);
		String[] array1=gson.fromJson(fbranch, String[].class);
		List<String> filmList=Arrays.asList(array1);
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
		String branchUrl ="http://localhost:9090/projectdb/admin/income/branch.do";
		String sbranch = service.get(branchUrl).trim();
		String filmUrl = "http://localhost:9090/projectdb/admin/income/film.do";
		String fbranch = service.get(filmUrl).trim();
		Gson gson=new Gson();
		String[] array=gson.fromJson(sbranch, String[].class);
		List<String> branchList=Arrays.asList(array);
		String[] array1=gson.fromJson(fbranch, String[].class);
		List<String> filmList=Arrays.asList(array1);
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
		String branchUrl ="http://localhost:9090/projectdb/admin/income/getMovieChat.do?filmName="+filmName;
		String sbranch = service.get(branchUrl).trim();
		return sbranch;
	}
	@RequestMapping("/admin/income/getBranchChat")
	@ResponseBody
	public String getBranchChat(String brName) {
		String branchUrl ="http://localhost:9090/projectdb/admin/income/getBranchChat.do?brName="+brName;
		String sbranch = service.get(branchUrl).trim();
		System.out.println("test:"+sbranch);
		return sbranch;
	}
}
