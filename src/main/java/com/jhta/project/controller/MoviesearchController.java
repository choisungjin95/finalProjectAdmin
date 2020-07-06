package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoviesearchController {
	@RequestMapping("/movieinfo/moviesearch.do")
	public String qna() {
		return ".movieinfo.moviesearch";
	}
	
}

