package com.happyhouse.Apart.dao;

import java.util.List;

import com.happyhouse.vo.ApartInfo;

public interface ApartInfoDao {
	public List<ApartInfo> aptSellList(String dongcode); //아파트 매매
	public List<ApartInfo> aptSellList(String dongcode, String search); //아파트 매매검색
	
}
