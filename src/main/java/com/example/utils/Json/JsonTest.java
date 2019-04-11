package com.example.utils.Json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/4/11 17:45
 * @Param ${tags}
 * @Description:
 */
public class JsonTest {

	public static void main(String[] args) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < 2; i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("AGE", 10);
			jsonObject.put("FULL NAME", "Doe " + i);
			jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");
			jsonArray.add(jsonObject);
		}
		String jsonOutput = jsonArray.toJSONString();
		System.out.println(jsonOutput);
	}
	@Test
	public void test(){
		Person person = new Person(20, "Doe", new Date());
		String jsonObject = JSON.toJSONString(person);
		Person newPerson = JSON.parseObject(jsonObject, Person.class);
		System.out.println(newPerson.getAge());
	}
}
