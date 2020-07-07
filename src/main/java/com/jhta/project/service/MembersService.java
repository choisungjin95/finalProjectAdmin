package com.jhta.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.MembersDao;
import com.jhta.project.vo.MembersVo;

@Service
public class MembersService {
	@Autowired
	private MembersDao dao;
	
	public int insert(MembersVo vo) {
		System.out.println("service");
		return dao.insert(vo);
	}
	
	
}
