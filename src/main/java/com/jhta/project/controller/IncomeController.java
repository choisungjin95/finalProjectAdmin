package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncomeController {
	@RequestMapping("/admin/movieIncome")
	public String getIncomeMoive() {
		return ".admin.moiveIncome";
	}
	
}
