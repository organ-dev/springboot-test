package com.example.utils.watchPay;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: ld
 * @Date: 2019/7/25 17:48
 * @Param ${tags}
 * @Description:
 */
public class XmlToMap {
	public static void main(String[] args) {
		XmlToMap xmlToMap=new XmlToMap();
		try {
			xmlToMap.testXmlToText();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testXmlToText() throws IOException {
		String xml = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("text.xml"));
		try {
			Map rtnMsg=WXPayUtil.xmlToMap(xml);
			System.out.println(rtnMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
