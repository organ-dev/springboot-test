package com.example.utils.watchUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: ld
 * @Date: 2019/7/25 13:40
 * @Param ${tags}
 * @Description: 获取配置地址
 */
public class WxEndpoint {
	private static final Logger log = LoggerFactory.getLogger(WxEndpoint.class);

	private static Properties endpoints;

	private static synchronized void loadProperties() {
		if (endpoints == null) {
			try {
				Properties properties = new Properties();
				InputStream inputStream = WxEndpoint.class.getClassLoader().getResourceAsStream("wx-app.properties");
				properties.load(inputStream);
				endpoints = properties;
			} catch (IOException e) {
				log.info("WxEndpoint is fail", e, e);
			}
		}
	}

	public static String get(String key) {
		loadProperties();
		return endpoints.getProperty(key);
	}
}
