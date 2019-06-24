package com.example.utils;

import java.math.BigDecimal;

/**
 * @Auther: ld
 * @Date: 2019/6/24 15:26
 * @Param ${tags}
 * @Description: 计算汇率值
 */
public class MathTest {
	public double getValue(String value, String rate) {
		double val = 0;
		try {
			BigDecimal v = new BigDecimal(value);
			BigDecimal r = new BigDecimal(rate);
			BigDecimal result = v.multiply(r).divide(new BigDecimal("100"));
			BigDecimal one = new BigDecimal("1");
			val = result.divide(one, 4, BigDecimal.ROUND_HALF_UP).doubleValue();
		} catch (Exception e) {
		}
		return val;
	}

	public static void main(String[] args) {
		MathTest mathTest = new MathTest();
		double val = mathTest.getValue("34.3237", "3.4");
		System.out.println(val);
	}
}
