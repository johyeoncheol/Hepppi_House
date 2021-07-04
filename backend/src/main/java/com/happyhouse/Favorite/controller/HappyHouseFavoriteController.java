package com.happyhouse.Favorite.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.Favorite.service.HappyHouseFavoriteService;
import com.happyhouse.Favorite.vo.favorite;


@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/favorite")
public class HappyHouseFavoriteController {
	
	@Autowired
	HappyHouseFavoriteService service;
	
	@GetMapping("/{ID}")
	public ResponseEntity<List<favorite>> getFavorite(@PathVariable String ID) {
		List<favorite> list = service.getFavorite(ID);
		//직선길이 짧은 길 찾기 알고리즘
				int n = list.size();
				double[][] adjArray = new double[n][n];
				int startIdx = 0;
				double startlat = 130, startlng = 130;
				for(int i = 0; i < n; i++) {
					double xlat = list.get(i).getLat();
					double xlng = list.get(i).getLng();
					//인접 리스트 설정
					for(int j = 0; j < n; j++) {
						if(i==j) continue;
						double ylat = list.get(j).getLat();
						double ylng = list.get(j).getLng();
						adjArray[i][j] = Math.sqrt(Math.pow(Math.abs(xlat-ylat), 2)+Math.pow(Math.abs(xlng-ylng), 2));
					}
					if(xlat < startlat) {
						startlat = xlat;
						startlng = xlng;
						startIdx = i;
					}
				}
				List<favorite> newList = new ArrayList<>();
				newList.add(list.get(startIdx));
				//방문확인배열
				boolean[] visited = new boolean[n];
				visited[startIdx] = true;
				
				for(int i = 0; i < n-1; i++) {
					int smallIdx = startIdx;
					double smalldist = 123456;
					for(int j = 0; j < n; j++) {
						if(visited[j]) continue; //이미 방문한 값
						if(smalldist > adjArray[startIdx][j]) {
							smallIdx = j;
							smalldist = adjArray[startIdx][j];
						}
					}
					visited[smallIdx] = true;
					startIdx = smallIdx;
					newList.add(list.get(startIdx));
				}
				
				
				
				if(list != null) {
					return new ResponseEntity<List<favorite>>(newList, HttpStatus.OK);
				}
				else {
					return new ResponseEntity(HttpStatus.NO_CONTENT);	
				}
	}
	
	@PostMapping("/")
	public ResponseEntity enrollFavorite(@RequestBody favorite favo){
		int val = service.enrollFavorite(favo);
		if(val != 0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
	
	
	@DeleteMapping("/{ID}/{AptName}/{area}")
	public ResponseEntity deleteFavorite(@PathVariable String ID, @PathVariable String AptName, @PathVariable String area){
		HashMap<String, String> inputVal = new HashMap<>();
		inputVal.put("ID", ID);
		inputVal.put("AptName", AptName);
		inputVal.put("area", area);		
		int val = service.deleteFavorite(inputVal);
		if(val != 0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);	
		}
	}
}
