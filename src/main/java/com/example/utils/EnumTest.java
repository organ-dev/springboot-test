package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2019/6/25 09:35
 * @Param ${tags}
 * @Description:
 */
public enum  EnumTest {
	ABC("1","abc");
	private String code;
	private String val;

	EnumTest(String code, String val) {
		this.code = code;
		this.val = val;
	}

	public String getCode() {
		return code;
	}

	public String getVal() {
		return val;
	}

}

