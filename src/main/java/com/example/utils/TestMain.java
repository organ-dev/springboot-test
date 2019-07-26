package com.example.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: ld
 * @Date: 2018/10/18 11:45
 * @Description:
 */
public class TestMain {
	public static void main(String[] args) {
		String str = "<ToUserName><![CDATA[gh_3fcea188bf78]]></ToUserName>";
		System.out.println(JSONObject.toJSONString(str));
	}
}
