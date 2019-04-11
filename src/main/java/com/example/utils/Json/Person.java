package com.example.utils.Json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/4/11 17:49
 * @Param ${tags}
 * @Description:
 */
public class Person {
	@JSONField(name = "AGE")
	private int age;

	@JSONField(name = "FULL NAME")
	private String fullName;

	@JSONField(name = "DATE OF BIRTH")
	private Date dateOfBirth;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person(int age, String fullName, Date dateOfBirth) {
		super();
		this.age = age;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
	}
	public Person() {

	}


}
