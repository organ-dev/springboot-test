package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/4/12 09:06
 * @Param ${tags}
 * @Description: jsonUtil
 */
public class JsonUtil {
	/**
	 * 转换器
	 */
	private final static ObjectMapper objectMapper = new ObjectMapper();

	protected static ObjectMapper getMapper() {
		return objectMapper;
	}

	/**
	 * 把java对象转换为json字符串
	 */
	public static String obj2Json(Object obj) {
		String json = null;
		try {
			json = JSONObject.toJSONString(obj);
		} catch (Exception e) {
			json = null;
		}
		return json;
	}

	/**
	 * 把json字符串转换为java对象
	 */
	public static <T> T json2Obj(String json, Class<T> clazz) {
		T obj = null;
		try {
			obj = JSON.parseObject(json, clazz);
		} catch (Exception e) {
			obj = null;
		}
		return obj;
	}

	/***
	 * json字符串批量转化
	 */
	public static List<?>  json2ListObj(String json, Class<?> clazz) {
		List<?> obgList = null;
		try {
			obgList = JSON.parseArray(json, clazz);
		} catch (Exception e) {
			obgList = null;
		}
		return obgList;
	}
}
