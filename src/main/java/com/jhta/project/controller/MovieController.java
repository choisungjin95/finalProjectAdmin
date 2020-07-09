package com.jhta.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jhta.project.service.GenreService;
import com.jhta.project.service.MovieBuyService;
import com.jhta.project.service.RestService;
import com.jhta.project.vo.FilmVo;
import com.jhta.project.vo.GenreVo;
import com.jhta.project.vo.MovieImgVo;

@Controller
public class MovieController {
	@Autowired
	private RestService service;
	
	@RequestMapping("/movieinfo/movie.do")
	public String movie() {
		return ".movieinfo.movie";
	}
	@RequestMapping("/movieinfo/moviebox.do")
	public String moviebox() {
		return ".movieinfo.moviebox";
	}
	
	@RequestMapping("/movieinfo/moviebuy.do")
	public String moviebuy(String title, Model model) throws IOException {
		StringBuffer sb=new StringBuffer();
		title=URLEncoder.encode(title,"UTF-8");
		String surl="https://openapi.naver.com/v1/search/movie.json?query="+title;	
		URL url=new URL(surl);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //java url ������ ����
		conn.setRequestProperty("X-Naver-Client-Id","qf1ksFUxXZziynfLDCaS");
	    conn.setRequestProperty("X-Naver-Client-Secret", "hjtFhODhB6");
	    if(conn!=null){
	    	conn.setConnectTimeout(10000);//���Ӵ��ð� 10�� ����
	    	conn.setUseCaches(false);//ĳ�������ϱ�
	    	if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){//�����κ��� ������ ���������� ������
	    		BufferedReader br=
	    		 new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
	    		String line="";
	    		while((line=br.readLine())!=null){
	    			sb.append(line);
	    		}
	    		br.close();
	    		conn.disconnect();
	    	}
	    }
	    String url1="http://localhost:9090/projectdb/movieinfo/genre.do";
	    String code=service.get(url1).trim();
	    Gson gson=new Gson();
		GenreVo[] array=gson.fromJson(code, GenreVo[].class);
		List<GenreVo> list=Arrays.asList(array);
	    model.addAttribute("api",sb.toString());
	    model.addAttribute("list",list);
		return ".movieinfo.movieinsert";
	}
	
	@PostMapping("/movieinfo/moviebuyOk.do")
	public String moviebuyok(FilmVo fvo, MovieImgVo mvo, String[] human) {
		try {
			String url="http://localhost:9090/projectdb/movieinfo/moviebuyOk.do";
			ObjectMapper mapper=new ObjectMapper();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			fvo.setFilmStart(sdf.parse(sdf.format(fvo.getFilmStart())));
			fvo.setFilmEnd(sdf.parse(sdf.format(fvo.getFilmEnd())));
			String jsonString= mapper.writeValueAsString(fvo);
			jsonString+= mapper.writeValueAsString(mvo);
			jsonString+= mapper.writeValueAsString(human);
			String code=service.post(url,jsonString);
			if(code.equals("success")) {
				return "/result/success";
			}else {
				return "/result/error";
			}
		}catch(Exception e) {
			return "/result/error";
		}
	}
}

