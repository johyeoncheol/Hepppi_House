package com.happyhouse.service;

import java.util.HashMap;
import java.util.List;

import com.happyhouse.vo.Environment;

public interface ExternalDataService {
	public List<Environment> allEnvironmentList();
	public HashMap<String, String> averageList(String dongCode);
	public List<HashMap<String, String>> getNews();
	public List<HashMap<String, String>> getApplyHome();
}
