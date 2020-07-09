package com.jhta.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.project.dao.MembershipDao;

@Service
public class MembershipServcie {
	@Autowired
	MembershipDao memberDao;
	public String getEmail(String memId) {
		System.out.println("***********membershipService Å¸±â*****************");
		return memberDao.getEmail(memId);
	}
}
