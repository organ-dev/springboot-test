package com.example.utils.Json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void test() {
		List<Person> ls = new ArrayList<>();
		Person person = new Person(20, "Doe", new Date());
		ls.add(person);
		String jsonObject = JSON.toJSONString(person);
		Person newPerson = JsonUtil.json2Obj(jsonObject, Person.class);
//		List<Person> ll = (List<Person>) JsonUtil.json2ListObj(JSONObject.toJSONString(ls), Person.class);
//		ll.stream().forEach(x ->System.out.println(x.getAge()));
		System.out.println(JSONObject.toJSONString(ls));
//		System.out.println(newPerson.getAge());
	}

}
