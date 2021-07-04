package com.happyhouse.Favorite.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.Favorite.dao.HappyHouseFavoriteDao;
import com.happyhouse.Favorite.vo.favorite;

@Service
public class HappyHouseFavoriteServiceImpl implements HappyHouseFavoriteService{
	
	@Autowired
	HappyHouseFavoriteDao dao;
	
	@Override
	public List<favorite> getFavorite(String ID){
		return dao.getFavorite(ID);
	}

	@Override
	public int enrollFavorite(favorite favo) {
		return dao.enrollFavorite(favo);
	}

	@Override
	public int deleteFavorite(HashMap<String, String> inputVal) {
		// TODO Auto-generated method stub
		return dao.deleteFavorite(inputVal);
	}

	@Override
	public List<favorite> findOne(String id, String no) {
		return dao.findOne(id,no);
	}
}
