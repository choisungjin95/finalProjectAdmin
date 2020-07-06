package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieinfoController {
	@RequestMapping("/movieinfo/movieinfo.do")
	public String movieinfo() {
		return ".movieinfo.movieinfo";
	}
	
}

