package com.happyhouse.Location.service;

import java.util.List;

import com.happyhouse.Location.vo.Location;

public interface HappyHouseLocationService {
	List<Location> cityList();
	List<Location> gugunList(Location loc);
	List<Location> dongList(Location loc);
}
