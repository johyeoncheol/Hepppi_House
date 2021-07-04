package com.happyhouse.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.ExternalData.dao.ApplyHomeDao;
import com.happyhouse.ExternalData.dao.AverageDao;
import com.happyhouse.ExternalData.dao.EnvironmentDao;
import com.happyhouse.ExternalData.dao.NewsDao;
import com.happyhouse.vo.Environment;

@Service
public class ExternalDataServiceImpl implements ExternalDataService {

	@Autowired
	EnvironmentDao envi;
	
	@Autowired
	AverageDao aver;
	
	@Autowired
	NewsDao news;
	
	@Autowired
	ApplyHomeDao ah;
	
	@Override
	//환경 데이터
	public List<Environment> allEnvironmentList() {
		return envi.selectAll();
	}

	@Override
	public HashMap<String, String> averageList(String dongCode) {
		return aver.averageList(dongCode);
	}

	@Override
	public List<HashMap<String, String>> getNews() {
		// TODO Auto-generated method stub
		return news.getNews();
	}

	@Override
	public List<HashMap<String, String>> getApplyHome() {
		// TODO Auto-generated method stub
		return ah.getApplyHome();
	}

}
