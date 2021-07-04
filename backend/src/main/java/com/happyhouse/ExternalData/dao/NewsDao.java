package com.happyhouse.ExternalData.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDao {
	static String baseURLF="https://search.naver.com/search.naver?ie=utf8&where=news&query=%EB%B6%80%EB%8F%99%EC%82%B0&sm=tab_pge&sort=0&photo=0&field=0&reporter_article=&pd=2&ds=2017.08.21&de=2017.09.20&docid=&nso=so:r,p:1m,a:all&mynews=0&cluster_rank=61&start=";
	static String baseURLB = "&refresh_start=0";
	static int baseURLP = 1;
	static String compURL = baseURLF + baseURLP + baseURLB;
	
	public List<HashMap<String, String>> getNews() {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		try {
			Document naver_news = Jsoup.connect(compURL)
									.header("Accept", "text/html, application/xhtml+xml, */*")
									.header("User-Agent", "Mozilla/5.0(Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko")
									.header("Accept-Encoding", "gzip, deflate")
									.header("Accept-Language", "ko-KR")
									.header("Connection", "Keep-Alive").get();
			
			Elements newsUrl = naver_news.select(".news_wrap");
			for(Element e : newsUrl) {
				String title = e.select(".news_tit").attr("title");
				String link = e.select(".news_tit").attr("href");
				String body = e.select(".dsc_txt_wrap").text();
				String imageLink = e.select(".dsc_thumb > .api_get").attr("src");
				HashMap<String, String> temp = new HashMap<>();
				temp.put("title", title);
				temp.put("body", body);
				temp.put("link", link);
				temp.put("imageLink", imageLink);
				list.add(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;						
	}
}
