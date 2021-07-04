package com.happyhouse.common.util;

import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AddressToGPS {
	
	// tag값의 정보를 가져오는 메소드
	public static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}
	
	public static double[] getLocation(String rnMgtSn, String admCd, String udrtYn, String buldMnnm, String buldSlno) {
		double [] location = {0, 0};
		try {
		StringBuilder urlBuilder = new StringBuilder("https://www.juso.go.kr/addrlink/addrCoordApi.do"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("confmKey","UTF-8") + "=U01TX0FVVEgyMDIxMDUyMDE0NTEzMDExMTE4Mjg="); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("admCd","UTF-8") + "=" + URLEncoder.encode(admCd, "UTF-8")); /*질의문*/
        urlBuilder.append("&" + URLEncoder.encode("rnMgtSn","UTF-8") + "=" + URLEncoder.encode(rnMgtSn, "UTF-8")); /*질의문*/
        urlBuilder.append("&" + URLEncoder.encode("udrtYn","UTF-8") + "=" + URLEncoder.encode(udrtYn, "UTF-8")); /*질의문*/
        urlBuilder.append("&" + URLEncoder.encode("buldMnnm","UTF-8") + "=" + URLEncoder.encode(buldMnnm, "UTF-8")); /*질의문*/
        urlBuilder.append("&" + URLEncoder.encode("buldSlno","UTF-8") + "=" + URLEncoder.encode(buldSlno, "UTF-8")); /*질의문*/
        
        String url = urlBuilder.toString();
        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		Document doc = dBuilder.parse(url);
		// root tag
		doc.getDocumentElement().normalize();

		// 파싱할 tag
		NodeList nList = doc.getElementsByTagName("juso");
		//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
		
		ProjCoordinate dstCoord = null;
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				try {
					location[0] = Double.parseDouble(getTagValue("entX", eElement));
					location[1] = Double.parseDouble(getTagValue("entY", eElement));
				} catch(Exception e) {
				}
				CRSFactory factory = new CRSFactory();
				CoordinateReferenceSystem srcCrs = factory.createFromName("EPSG:5179");
				CoordinateReferenceSystem dstCrs = factory.createFromName("EPSG:4326");
				BasicCoordinateTransform transform = new BasicCoordinateTransform(srcCrs, dstCrs);
				ProjCoordinate srcCoord = new ProjCoordinate(location[0], location[1]);
				dstCoord = new ProjCoordinate();
				transform.transform(srcCoord, dstCoord);//좌표변환
				location[0] = dstCoord.y;
				location[1] = dstCoord.x;
			} // for end
		} // if end
		} catch(Exception e) {
			e.printStackTrace();
		}

		return location;
	}
}
