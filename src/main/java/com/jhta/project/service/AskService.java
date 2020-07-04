package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.AskDao;
import com.jhta.project.vo.AskVo;
import com.jhta.project.vo.ReplyVo;

@Service
public class AskService {
	@Autowired
	private AskDao dao;
	
	public List<AskVo> list(){
		return dao.list();
	}
	public AskVo getinfo(int askNum) {
		return dao.getinfo(askNum);
	}
	public int replyInsert(ReplyVo vo) {
		return dao.replyInsert(vo);
	}
}
