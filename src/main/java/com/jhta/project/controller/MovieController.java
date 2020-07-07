package com.jhta.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
	@RequestMapping("/movieinfo/movie.do")
	public String movie() {
		return ".movieinfo.movie";
	}
	
	@RequestMapping("/movieinfo/moviebuy.do")
	public String moviebuy(String title, Model model) throws IOException {
		StringBuffer sb=new StringBuffer();
		title=URLEncoder.encode(title,"UTF-8");
		String surl="https://openapi.naver.com/v1/search/movie.json?query="+title+"&display=5";	
		URL url=new URL(surl);
		System.out.println("url:"+url);
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
	    		System.out.println("============"+sb.toString());
	    		conn.disconnect();//���̹��� ��������
	    	}
	    }
	    model.addAttribute("api",sb.toString());
	    
		return ".movieinfo.movieinsert";
	}
}

