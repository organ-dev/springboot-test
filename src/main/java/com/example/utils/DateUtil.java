package com.example.utils;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2018/10/8 10:57
 * @Description:
 */
public class DateUtil {
    public Date parseDate(String str, String... parsePatterns) throws ParseException {

        Date date = DateUtils.parseDate(str, parsePatterns);
        return date;
    }

    //判断两个日期时间是否是同一天
    public boolean isSameDay(final Date date1, final Date date2) {
        Boolean bl = DateUtils.isSameDay(date1, date2);
        return bl;
    }

    public Date parseDateStrictly(final String str, final String... parsePatterns) throws ParseException {
        Date date = DateUtils.parseDateStrictly(str, parsePatterns);
        return date;
    }

    /**
     * 在日期date上增加amount年 。
     *
     * @param date   处理的日期，非null
     * @param amount 要加的年数，可能为负数
     */
    public Date addYears(final Date date, final int amount) {
        Date date1 = DateUtils.addYears(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount月 。     *     * @param date  处理的日期，非null     * @param amount  要加的月数，可能为负数
     */
    public Date addMonths(final Date date, final int amount) {
        Date date1 = DateUtils.addMonths(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount周 。     *     * @param date  处理的日期，非null     * @param amount  要加的周数，可能为负数
     */
    public Date addWeeks(final Date date, final int amount) {
        Date date1 = DateUtils.addWeeks(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount天 。     *     * @param date  处理的日期，非null     * @param amount  要加的天数，可能为负数
     */
    public Date addDays(final Date date, final int amount) {
        Date date1 = DateUtils.addDays(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount小时 。     *     * @param date  处理的日期，非null     * @param amount  要加的小时数，可能为负数
     */
    public Date addHours(final Date date, final int amount) {
        Date date1 = DateUtils.addHours(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount分钟 。     *     * @param date  处理的日期，非null     * @param amount  要加的分钟数，可能为负数
     */
    public Date addMinutes(final Date date, final int amount) {
        Date date1 = DateUtils.addMinutes(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount秒 。     *     * @param date  处理的日期，非null     * @param amount  要加的秒数，可能为负数
     */
    public Date addSeconds(final Date date, final int amount) {
        Date date1 = DateUtils.addSeconds(date, amount);
        return date1;
    }

    /**
     * 在日期date上增加amount 毫秒 。
     * *
     * * @param date  处理的日期，非null
     * * @param amount  要加的毫秒数，可能为负数
     */
    public Date addMilliseconds(final Date date, final int amount) {
        Date date1 = DateUtils.addMilliseconds(date, amount);
        return date1;
    }

    /**
     * 给日期data设置一个新的年份 。     *     * @param date 处理的日期，非null     * @param amount 要设置的年份
     */
    public Date setYears(final Date date, final int amount) {
        Date date1 = DateUtils.setYears(date, amount);
        return date1;
    }

    /**
     * 截取比较两个日期对象的field处的值是否相同 。
     *
     * @param date1 第一个日期对象，非null
     * @param date2 第二个日期对象，非null
     * @param field Calendar中的阈值
     */
    public  boolean truncatedEquals(final Date date1, final Date date2, final int field){
        Boolean bl=DateUtils.truncatedEquals(date1,date2,field);
        return bl;
    }
    /**
     * @Title: getCurrentDateString
     * @Description: 得到当前日期字符串:yyyymmdd
     * @return String:yyyyMMdd
     * @throws
     */
    public static String getCurrentDateString() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        return "" + calendar.get(Calendar.YEAR)
                + (month < 10 ? "0" + month : "" + month)
                + (date < 10 ? "0" + date : "" + date);
    }
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }
    public static void main(String[] args) {
        DateUtil dateUtil = new DateUtil();
        String[] parsePatterns = {"yyyy-MM-dd HH:mm:ss"};
        try {
            System.out.println(dateUtil.parseDate("2018-10-08 11:10:00", parsePatterns));
            System.out.println(dateUtil.isSameDay(new Date(), dateUtil.parseDate("2018-10-04 11:10:00", parsePatterns)));
            System.out.println(dateUtil.parseDateStrictly("2018-10-08 11:10:00", parsePatterns));
            System.out.println(dateUtil.addYears(new Date(), 1));
            System.out.println(dateUtil.setYears(new Date(), 2088));
            System.out.println(dateUtil.truncatedEquals(new Date(),new Date(), 0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
