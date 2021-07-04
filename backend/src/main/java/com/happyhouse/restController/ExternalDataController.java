package com.happyhouse.restController;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.service.ExternalDataService;
import com.happyhouse.vo.Environment;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
public class ExternalDataController {
	
	@Autowired
	ExternalDataService service;
	
	@GetMapping("/environment")
	public ResponseEntity<List<Environment>> enviAllList() {
		List<Environment> list = service.allEnvironmentList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Environment>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/average/{dongCode}")
	public ResponseEntity<HashMap<String, String>> averageList(@PathVariable String dongCode) {
		HashMap<String, String> list = service.averageList(dongCode);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<HashMap<String, String>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/news")
	public ResponseEntity<List<HashMap<String, String>>> getNews() {
		List<HashMap<String, String>> list = service.getNews();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HashMap<String, String>>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/applyhome")
	public ResponseEntity<List<HashMap<String, String>>> getApplyHome() {
		List<HashMap<String, String>> list = service.getApplyHome();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<HashMap<String, String>>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
