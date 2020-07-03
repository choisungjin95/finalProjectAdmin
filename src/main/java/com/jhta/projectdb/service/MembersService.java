package com.jhta.projectdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.projectdb.dao.MembersDao;
import com.jhta.projectdb.vo.MembersVo;

@Service
public class MembersService {
	@Autowired
	private MembersDao dao;
	
	public int insert(MembersVo vo) {
		System.out.println("service");
		return dao.insert(vo);
	}
}
