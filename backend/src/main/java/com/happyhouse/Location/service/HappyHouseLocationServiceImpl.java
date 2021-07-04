package com.happyhouse.Location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.Location.dao.HappyHouseLocationDao;
import com.happyhouse.Location.vo.Location;

@Service
public class HappyHouseLocationServiceImpl implements HappyHouseLocationService {

	@Autowired
	HappyHouseLocationDao dao;
	
	@Override
	public List<Location> cityList() {
		return dao.cityList();
	}

	@Override
	public List<Location> gugunList(Location loc) {
		return dao.gugunList(loc);
	}

	@Override
	public List<Location> dongList(Location loc) {
		// TODO Auto-generated method stub
		return dao.dongList(loc);
	}

}
