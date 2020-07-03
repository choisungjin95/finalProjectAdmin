package com.jhta.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.ProposalDao;
import com.jhta.project.vo.ProposalVo;
@Service
public class ProposalService {
	@Autowired
	private ProposalDao proDao;
	public List<ProposalVo> selectList() {
		List<ProposalVo> list = proDao.selectList();
		System.out.println("service:"+list);
		return list;
	}
}
