package com.happyhouse.Apart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.Apart.dao.ApartInfoDao;
import com.happyhouse.vo.ApartInfo;

@Service
public class ApartInfoServiceImpl implements ApartInfoService {

	@Autowired
	ApartInfoDao dao;
	
	@Override
	public List<ApartInfo> aptSellList(String dongcode) {
		return dao.aptSellList(dongcode);
	}

	@Override
	public List<ApartInfo> aptSellList(String dongcode, String search) {
		// TODO Auto-generated method stub
		return dao.aptSellList(dongcode, search);
	}

}
