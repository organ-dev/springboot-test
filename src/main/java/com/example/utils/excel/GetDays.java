package com.example.utils.excel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * @Auther: ld
 * @Date: 2020/1/14 16:32
 * @Param ${tags}
 * @Description:
 */
public class GetDays {
	public static void main(String[] args) {
		List ls=getDayByMonth(2020,1);
//		for (Object s:ls) {
//			System.out.println(s);
//		}
		List ll=getWeekendInMonth(2020,1);
		for (Object s:ll) {
			System.out.println(s);
		}
	}

	public static List<String> getDayByMonth(int yearParam, int monthParam) {
		List list = new ArrayList();
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		aCalendar.set(yearParam, monthParam, 0);
		int year = aCalendar.get(Calendar.YEAR);//年份
		int month = aCalendar.get(Calendar.MONTH) + 1;//月份
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= day; i++) {
			String aDate = null;
			if (month < 10 && i < 10) {
				aDate = String.valueOf(year) + "-0" + month + "-0" + i;
			}
			if (month < 10 && i >= 10) {
				aDate = String.valueOf(year) + "-0" + month + "-" + i;
			}
			if (month >= 10 && i < 10) {
				aDate = String.valueOf(year) + "-" + month + "-0" + i;
			}
			if (month >= 10 && i >= 10) {
				aDate = String.valueOf(year) + "-" + month + "-" + i;
			}

			list.add(aDate);
		}
		return list;
	}
	/**
	 * 获取当月的所有周末
	 * @param year
	 * @param month
	 * @return
	 */
	public static List getWeekendInMonth(int year, int month) {
		List list = new ArrayList();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);// 不设置的话默认为当年
		calendar.set(Calendar.MONTH, month - 1);// 设置月份
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为当月第一天
		int daySize = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 当月最大天数
		for (int i = 0; i < daySize-1; i++) {
			calendar.add(Calendar.DATE, 1);//在第一天的基础上加1
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			if (week == Calendar.SATURDAY || week == Calendar.SUNDAY) {// 1代表周日，7代表周六 判断这是一个星期的第几天从而判断是否是周末
				list.add(year+"-"+month+"-"+calendar.get(Calendar.DAY_OF_MONTH));// 得到当天是一个月的第几天
			}
		}
		return list;
	}
}
