package com.jhta.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.BranchDao;
import com.jhta.project.vo.BranchVo;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	public List<BranchVo> list(HashMap<String,Object> map){
		return dao.list(map);
	}
	public int count() {
		return dao.count();
	}

}
