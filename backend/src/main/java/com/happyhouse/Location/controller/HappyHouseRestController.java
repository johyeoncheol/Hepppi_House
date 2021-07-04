package com.happyhouse.Location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.Location.service.HappyHouseLocationService;
import com.happyhouse.Location.vo.Location;
import com.happyhouse.vo.ApartInfo;

@RestController
@RequestMapping(value = "/location")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class HappyHouseRestController {

	@Autowired
	HappyHouseLocationService service;
	
	//도 광역시 정보 보냄
	@GetMapping(value="/cityList")
	public ResponseEntity<List<Location>> cityList(){
		List<Location> list =  service.cityList();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
	
	//시/구/군정보 보냄
	@GetMapping(value="/cityList/{city}")
	public ResponseEntity<List<Location>> gugunList(@PathVariable String city){
		Location loc = new Location();
		loc.setCity(city);
		List<Location> list =  service.gugunList(loc);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
	
	//동 정보 출력
	@GetMapping(value="/cityList/{city}/{gugun}")
	public ResponseEntity<List<Location>> dongList(@PathVariable String city, @PathVariable String gugun){
		Location loc = new Location();
		loc.setCity(city);
		loc.setGugun(gugun);
		List<Location> list =  service.dongList(loc);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
}
