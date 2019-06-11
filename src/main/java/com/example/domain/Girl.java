package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by Aidon on 17/7/8.
 */
@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	private String cupSize;
	@Min(value = 18, message = "未成年")
	private Integer age;

	private String name;
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	public Girl() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCupSize() {
		return cupSize;
	}

	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Girl{" +
				"id=" + id +
				", cupSize='" + cupSize + '\'' +
				", age=" + age +
				'}';
	}
}
