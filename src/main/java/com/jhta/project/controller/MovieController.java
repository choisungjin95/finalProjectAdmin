package com.jhta.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	@RequestMapping("/movieinfo/movie.do")
	public String qna() {
		return ".movieinfo.movie";
	}
	
}

