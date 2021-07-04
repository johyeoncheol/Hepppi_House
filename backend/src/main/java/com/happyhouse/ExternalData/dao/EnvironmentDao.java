package com.happyhouse.ExternalData.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.happyhouse.vo.Environment;

@Repository
public class EnvironmentDao {

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	public List<Environment> selectAll() {
		
		List<Environment> list = new ArrayList<>();
		try {
			// parsing할 url 지정(API 키 포함해서) //jongno만 바뀌면 다른거 불러올 수 있음.
			String url = "http://openapi.jongno.go.kr:8088/6c5578717a796f6f37374878735769/xml/JongnoListEnvGuideCheck/1/100";

			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(url);

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("row");
			// System.out.println("파싱할 리스트 수 : "+ nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					list.add(new Environment(getTagValue("WRKP_NM", eElement), getTagValue("DRT_INSP_YMD", eElement), getTagValue("WRKP_ADDR", eElement)));
				} // for end
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		return list;
	}
}