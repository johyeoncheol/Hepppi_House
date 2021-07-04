package com.happyhouse.Favorite.dao;

import java.util.HashMap;
import java.util.List;

import com.happyhouse.Favorite.vo.favorite;

public interface HappyHouseFavoriteDao {

	public List<favorite> getFavorite(String ID);
	public int enrollFavorite(favorite favo);
	public int deleteFavorite(HashMap<String, String> inputVal);
	public List<favorite> findOne(String id, String no);
}
