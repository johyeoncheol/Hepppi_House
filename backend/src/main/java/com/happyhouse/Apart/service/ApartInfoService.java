package com.happyhouse.Apart.service;

import java.util.List;

import com.happyhouse.vo.ApartInfo;

public interface ApartInfoService {
	
	public List<ApartInfo> aptSellList(String dongcode); //아파트 매매
	/* - 불가능 -> 지도로 표기할 수 있는 정보가 부족함
	public List<ApartInfo> aptLeaseList(String dongcode); //아파트 전월세
	public List<ApartInfo> multiSellList(String dongcode); //연립다세대 매매
	public List<ApartInfo> multiLeaseList(String dongcode); //연립다세대 전월세
	*/
	public List<ApartInfo> aptSellList(String dongcode, String search);
}
