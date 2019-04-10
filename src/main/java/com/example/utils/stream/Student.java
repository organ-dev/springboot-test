package com.example.utils.stream;

/**
 * @Auther: ld
 * @Date: 2019/4/10 15:05
 * @Param ${tags}
 * @Description:
 */
public class Student {
	private String name;
	private Integer score;

	public Student(String s, int i) {
		name=s;
		score=i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
