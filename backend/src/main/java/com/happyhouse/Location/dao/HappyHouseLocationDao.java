package com.happyhouse.Location.dao;

import java.util.List;

import com.happyhouse.Location.vo.Location;

public interface HappyHouseLocationDao {
	List<Location> cityList();
	List<Location> gugunList(Location loc);
	List<Location> dongList(Location loc);
}
