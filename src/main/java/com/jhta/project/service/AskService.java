package com.jhta.project.service;

import java.util.HashMap;
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
	
	public List<AskVo> list(HashMap<String, Object> map){
		return dao.list(map);
	}
	public AskVo askGetinfo(int askNum) {
		return dao.askGetinfo(askNum);
	}
	public ReplyVo replyGetinfo(int askNum) {
		return dao.replyGetinfo(askNum);
	}
	//답변 수정
	public int replyUpdate(ReplyVo vo) {
		return dao.replyUpdate(vo);
	}
	//답변상태
	public int respUpdate(int askNum) {
		return dao.respUpdate(askNum);
	}
	
//	public int replyInsert(ReplyVo vo) {
//		return dao.replyInsert(vo);
//	}
	public int count() {
		return dao.count();
	}
}
