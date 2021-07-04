package com.happyhouse.Apart.dao;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.happyhouse.common.util.AddressToGPS;
import com.happyhouse.vo.ApartInfo;

@Repository
public class ApartInfoDaoImpl implements ApartInfoDao{

		private List<ApartInfo> list = new ArrayList<>();
	
	    public List<ApartInfo> aptSellList(String dongcode)  {
	    	list.clear();
	    	int temp = 0;
	    	try {
		        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ijl7bSqbHHGb43A2LecCa6Pms2iUeZk1bt5yaEn0QKSmjWLByAUE5lWQD1luK%2FeeV2P6B7E%2BQRfHMBNlx5aROQ%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
		        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode(dongcode, "UTF-8")); /*지역코드*/
		        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202012", "UTF-8")); /*계약월*/
		       
		        String url = urlBuilder.toString();
		        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
		    	
				// root tag
				doc.getDocumentElement().normalize();
				String totalCount = doc.getElementsByTagName("totalCount").item(0).getTextContent();
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				System.out.println("파싱할 리스트 수 : "+ nList.getLength());
	
				for (temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						//위치정보
						StringBuilder rnMgtSn = new StringBuilder();
						StringBuilder admCd = new StringBuilder();
						rnMgtSn.append(AddressToGPS.getTagValue("도로명시군구코드", eElement)); //도로명시군구코드
						rnMgtSn.append(AddressToGPS.getTagValue("도로명코드", eElement)); //도로명코드
						admCd.append(AddressToGPS.getTagValue("법정동시군구코드", eElement)); //도로명코드
						admCd.append(AddressToGPS.getTagValue("법정동읍면동코드", eElement)); //법정동읍면동코드
						String udrtYn = AddressToGPS.getTagValue("도로명지상지하코드", eElement); //도로명지상지하코드
						String buldMnnm = AddressToGPS.getTagValue("도로명건물본번호코드", eElement); //도로명건물본번호코드
						String buldSlno = AddressToGPS.getTagValue("도로명건물부번호코드", eElement); //도로명건물부번호코드
						String dong = AddressToGPS.getTagValue("법정동", eElement); //동 이름
						String AptName = AddressToGPS.getTagValue("아파트", eElement); //아파트 이름
						String dealAmount = AddressToGPS.getTagValue("거래금액", eElement); //아파트 이름
						String area = AddressToGPS.getTagValue("전용면적", eElement); //전용면적
						String floor = AddressToGPS.getTagValue("층", eElement); //층
						String buildYear = AddressToGPS.getTagValue("건축년도", eElement); //층
						String dealYear = AddressToGPS.getTagValue("년", eElement); //년
						String dealMonth = AddressToGPS.getTagValue("월", eElement); //월
						String dealDay = AddressToGPS.getTagValue("일", eElement); //일
						
						double[] location = AddressToGPS.getLocation(rnMgtSn.toString(), admCd.toString(), udrtYn, buldMnnm, buldSlno);
						ApartInfo a = new ApartInfo(temp+1, dong, AptName, dealAmount, area, floor, buildYear, dealYear, dealMonth, dealDay, "아파트 매매", location[0], location[1], totalCount, 0);
						list.add(a);
					} // for end
				} // if end
	    	} catch(Exception e) {
	    		System.out.println(list.size());
	    		e.printStackTrace();
	    	}
			return list;
	    }

		@Override
		public List<ApartInfo> aptSellList(String dongcode, String search) {
			list.clear();
	    	int temp = 0;
	    	try {
		        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
		        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ijl7bSqbHHGb43A2LecCa6Pms2iUeZk1bt5yaEn0QKSmjWLByAUE5lWQD1luK%2FeeV2P6B7E%2BQRfHMBNlx5aROQ%3D%3D"); /*Service Key*/
		        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
		        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode(dongcode, "UTF-8")); /*지역코드*/
		        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("202012", "UTF-8")); /*계약월*/
		       
		        String url = urlBuilder.toString();
		        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
		    	
				// root tag
				doc.getDocumentElement().normalize();
				//String totalCount = doc.getElementsByTagName("totalCount").item(0).getTextContent();
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				
				int aptCnt = 0;
				int allCnt = 0;
	
				for (temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						
						//위치정보
						String AptName = AddressToGPS.getTagValue("아파트", eElement); //아파트 이름
						//만약 해당 아파트가 아니면.
						if(!AptName.contains(search)) continue;
						allCnt++;
						if(aptCnt >= 10) continue;
						aptCnt++;
						StringBuilder rnMgtSn = new StringBuilder();
						StringBuilder admCd = new StringBuilder();
						rnMgtSn.append(AddressToGPS.getTagValue("도로명시군구코드", eElement)); //도로명시군구코드
						rnMgtSn.append(AddressToGPS.getTagValue("도로명코드", eElement)); //도로명코드
						admCd.append(AddressToGPS.getTagValue("법정동시군구코드", eElement)); //도로명코드
						admCd.append(AddressToGPS.getTagValue("법정동읍면동코드", eElement)); //법정동읍면동코드
						String udrtYn = AddressToGPS.getTagValue("도로명지상지하코드", eElement); //도로명지상지하코드
						String buldMnnm = AddressToGPS.getTagValue("도로명건물본번호코드", eElement); //도로명건물본번호코드
						String buldSlno = AddressToGPS.getTagValue("도로명건물부번호코드", eElement); //도로명건물부번호코드
						String dong = AddressToGPS.getTagValue("법정동", eElement); //동 이름
						
						String dealAmount = AddressToGPS.getTagValue("거래금액", eElement); //아파트 이름
						String area = AddressToGPS.getTagValue("전용면적", eElement); //전용면적
						String floor = AddressToGPS.getTagValue("층", eElement); //층
						String buildYear = AddressToGPS.getTagValue("건축년도", eElement); //층
						String dealYear = AddressToGPS.getTagValue("년", eElement); //년
						String dealMonth = AddressToGPS.getTagValue("월", eElement); //월
						String dealDay = AddressToGPS.getTagValue("일", eElement); //일
						
						double[] location = AddressToGPS.getLocation(rnMgtSn.toString(), admCd.toString(), udrtYn, buldMnnm, buldSlno);
						ApartInfo a = new ApartInfo(temp+1, dong, AptName, dealAmount, area, floor, buildYear, dealYear, dealMonth, dealDay, "아파트 매매", location[0], location[1], "0", 0);
						list.add(a);
					} // for end
				} // if end
				list.get(0).setTotalCount(Integer.toString(allCnt));
	    	} catch(Exception e) {
	    		System.out.println(list.size());
	    		e.printStackTrace();
	    	}
			return list;
		}

	
}
