package com.example.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Auther: ld
 * @Date: 2019/6/24 15:26
 * @Param ${tags}
 * @Description: 计算汇率值
 */
public class MathTest {
	public String getValue(String value, String rate) {
		String val = "";
		try {
			BigDecimal v = new BigDecimal(value);
			BigDecimal r = new BigDecimal(rate);
			BigDecimal result = v.multiply(r).divide(new BigDecimal("100"));
			BigDecimal one = new BigDecimal("1");
			val = result.divide(one, 4, BigDecimal.ROUND_HALF_UP).toString();
			String decimalFormat=new DecimalFormat("0.0000").format(new Double(val));
		} catch (Exception e) {
		}
		return val;
	}

	public static void main(String[] args) {
		MathTest mathTest = new MathTest();
		String val = mathTest.getValue("34.434", "3.4");
		System.out.println(val);
	}
}
