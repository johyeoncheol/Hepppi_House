package com.happyhouse.service;

import java.util.Map;

import com.happyhouse.vo.Member;

public interface MemberService {
	public Member login(Member member);
	public int memberUpdate(Member member);
	public Member memberView(String id);
	public int signup(Member member);
	public Member passwdSearch(Member member);
	public String duplicateCheck(String id);
}
