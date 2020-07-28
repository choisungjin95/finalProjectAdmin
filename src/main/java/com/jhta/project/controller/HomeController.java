package com.jhta.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private boolean bl=false;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session) {
		String cp=session.getServletContext().getContextPath();
		session.getServletContext().setAttribute("cp",cp);
		if(!bl) {
			return "checking";
		}else {
			return ".main";
		}
	}
	@RequestMapping(value="/main.do")
	public String main(String pwd,Model model,HttpSession session) {
		if(pwd.equals("admin")) {
			bl=true;
			return ".main";
		}else{
			model.addAttribute("checkPwd","비밀번호를 확인해주세요");
			return "checking";
		}
	}
	
}
