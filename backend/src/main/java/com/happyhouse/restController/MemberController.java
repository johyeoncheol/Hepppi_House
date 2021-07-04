package com.happyhouse.restController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.common.util.AddressToGPS;
import com.happyhouse.service.MemberService;
import com.happyhouse.vo.Member;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody Member member) {
		Member loginMember = service.login(member);
		//test
		if(loginMember != null) {
			return new ResponseEntity<Member>(loginMember, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody Member member) {
		double[] location = AddressToGPS.getLocation(member.getRnMgtSn(), member.getAdmCd(), member.getUdrtYn(), member.getBuldMnnm(), member.getBuldSlno());
		member.setLat(location[0]);
		member.setLng(location[1]);
		int val = service.signup(member);
		
		if(val != 0) {
			return new ResponseEntity<String>("signup!!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/duplicate/{id}")
	public ResponseEntity<String> duplicateCheck(@PathVariable String id){
		String findId = service.duplicateCheck(id);
		if(findId == null) findId = "";
		return new ResponseEntity<String>(findId, HttpStatus.OK);
	}

}
