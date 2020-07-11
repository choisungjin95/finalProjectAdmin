package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.QnaDao;
import com.jhta.project.vo.QnaVo;

@Service
public class QnaService {
	@Autowired
	private QnaDao dao;
	
	public QnaVo getinfo(int qnaNum) {
		return dao.getinfo(qnaNum);
	}
	
	public int insert(QnaVo vo) {
		return dao.insert(vo);
	}
	
	public List<QnaVo> list(HashMap<String, Object> map){
		return dao.list(map);
	}
	
	public int update(QnaVo vo) {
		return dao.update(vo);
	}
	
	public int delete(int qnaNum) {
		return dao.delete(qnaNum);
	}
	
	public int count() {
		return dao.count();
	}
}
