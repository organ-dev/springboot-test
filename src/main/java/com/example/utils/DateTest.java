package com.example.utils;

import com.example.utils.DruidConfig.StringPlus;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aidon on 19/7/27.
 * 去除小数点后面的零：https://blog.csdn.net/xuwei_net/article/details/81508634
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTime = System.currentTimeMillis() + 120 * 60 * 1000;
        long beginTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        Date date1 = new Date(beginTime);

        System.out.println("currentTime=" + currentTime + ",beginTime=" + beginTime);
        if (beginTime - currentTime < 0) {
            System.out.println("当前时间小于结束时间");
        }
        System.out.println(dateFormat.format(date));
        System.out.println(dateFormat.format(date1));
        BigDecimal balance=new BigDecimal("50.00");
        BigDecimal ab=balance.add(balance);
        System.out.println(StringPlus.removeAmtLastZero(ab));
    }
}
