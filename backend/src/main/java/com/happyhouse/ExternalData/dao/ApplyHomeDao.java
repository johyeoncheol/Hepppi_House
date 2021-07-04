package com.happyhouse.ExternalData.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Repository;

@Repository
public class ApplyHomeDao {
	
	static String baseURLF="https://www.applyhome.co.kr/ai/aib/selectSubscrptCalender.do";
	static String[] typeMatching= {"","APT 특별 공급","APT 1순위","APT 2순위","민간임대","오피스텔/도시형","무순위/취소후재공급",};

	public List<HashMap<String, String>> getApplyHome() {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		try {
			//시간 얻어오기
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMM");
			Date time = new Date();
			String time1 = format1.format(time);
			//정보획득
			String jsonBody = "{\"reqData\":{\"inqiredPd\":\""+time1+"\"}}";
			Document applyhome = Jsoup.connect(baseURLF)
									.ignoreContentType(true)
									.header("User-Agent", "Mozilla/5.0(Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko")
									.header("Accept-Encoding", "gzip, deflate")
									.header("Accept-Language", "ko-KR")
									.header("Connection", "Keep-Alive")
									.header("Content-Type","application/json")
									.requestBody(jsonBody)
									.post();
			
			String applyhomeInfo = applyhome.select("body").text();
			JSONObject jObject = new JSONObject(applyhomeInfo);
			JSONArray jArray = jObject.getJSONArray("schdulList");
			
			for(int i = 0; i < jArray.length(); i++) {
				JSONObject obj = jArray.getJSONObject(i);
				String title = obj.getString("HOUSE_NM");
				String date = obj.getString("IN_DATE");
				String type = obj.getString("RCEPT_SE");
				HashMap<String, String> data = new HashMap<>();
				data.put("title", title);
				data.put("date", date);
				data.put("type", typeMatching[Integer.parseInt(type)]);
				list.add(data);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
}
