package com.happyhouse.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.dao.MemberDao;
import com.happyhouse.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public Member login(Member member) {
		// TODO Auto-generated method stub
		return dao.login(member);
	}

	@Override
	public int memberUpdate(Member member) {
		// TODO Auto-generated method stub
		return dao.memberUpdate(member);
	}

	@Override
	public Member memberView(String id) {
		// TODO Auto-generated method stub
		return dao.memberView(id);
	}

	@Override
	public int signup(Member member) {
		// TODO Auto-generated method stub
		return dao.signup(member);
	}

	@Override
	public Member passwdSearch(Member member) {
		// TODO Auto-generated method stub
		return dao.passwdSearch(member);
	}

	@Override
	public String duplicateCheck(String id) {
		// TODO Auto-generated method stub
		return dao.duplicateCheck(id);
	}

}
