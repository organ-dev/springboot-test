package com.example.utils.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: ld
 * @Date: 2019/7/8 13:57
 * @Param ${tags}
 * @Description:
 */
public class DateTimeFormatterTest {
	public static void main(String[] args) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date=LocalDate.now();
		System.out.println(date.format(formatter));

	}
}
