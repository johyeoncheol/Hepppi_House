package com.happyhouse.Apart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.Apart.service.ApartInfoService;
import com.happyhouse.Location.vo.Location;
import com.happyhouse.vo.ApartInfo;

@RestController
@RequestMapping("/aptList")
public class ApartController {

	@Autowired
	ApartInfoService service;
	
	@GetMapping("/{dongcode}")
	public ResponseEntity<List<ApartInfo>> cityList(@PathVariable String dongcode){
		List<ApartInfo> list =  service.aptSellList(dongcode);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<ApartInfo>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
	
	@GetMapping("/{dongcode}/{search}")
	public ResponseEntity<List<ApartInfo>> cityList(@PathVariable String dongcode, @PathVariable String search){
		List<ApartInfo> list =  service.aptSellList(dongcode, search);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<ApartInfo>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
}
