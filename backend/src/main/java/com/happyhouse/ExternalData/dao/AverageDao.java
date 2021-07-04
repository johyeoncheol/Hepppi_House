package com.happyhouse.ExternalData.dao;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.happyhouse.common.util.AddressToGPS;

@Repository
public class AverageDao {
	
	private HashMap<String, String> list = new HashMap<>();
	
	 public HashMap<String, String> averageList(String dongCode)  {
	    	list.clear();
	    	int temp = 0;
	    	try {
		        StringBuilder urlBuilder = new StringBuilder("http://openapi.reb.or.kr/OpenAPI_ToolInstallPackage/service/rest/AptRealPrcIndexSvc/getAptRealPrcIndex"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ijl7bSqbHHGb43A2LecCa6Pms2iUeZk1bt5yaEn0QKSmjWLByAUE5lWQD1luK%2FeeV2P6B7E%2BQRfHMBNlx5aROQ%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("startmonth","UTF-8") + "=" + URLEncoder.encode("202004", "UTF-8")); /*시작 날*/
		        urlBuilder.append("&" + URLEncoder.encode("endmonth","UTF-8") + "=" + URLEncoder.encode("202104", "UTF-8")); /*끝나는 날*/
		        urlBuilder.append("&" + URLEncoder.encode("region","UTF-8") + "=" + URLEncoder.encode(dongCode.substring(0, 2)+"000", "UTF-8")); /*지역*/
		       
		        String url = urlBuilder.toString();
		        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
		    	
				// root tag
				doc.getDocumentElement().normalize();
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				
	
				for (temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String Si = AddressToGPS.getTagValue("regionNm", eElement);
						list.put("Si", Si);
						String[] rsRows = AddressToGPS.getTagValue("rsRow", eElement).split("\\|"); //평균 데이터
						for(String t : rsRows) {
							String[] rsRow = t.split(",");
							System.out.println(rsRow[0]+" "+rsRow[1]);
							list.put(rsRow[0], rsRow[1].trim());
						}
					} // for end
				} // if end
	    	} catch(Exception e) {
	    		System.out.println(list.size());
	    		e.printStackTrace();
	    	}
			return list;
	    }
}
