package com.example.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/3/20 09:27
 * @Param ${tags}
 * @Description:
 */
@Component
public class PrintTask {
@Scheduled(initialDelay = 1000*5,fixedRate = 1000*1)
public void cron() throws Exception{
//    Thread.sleep(2000);
    System.out.println("执行测试"+new Date(System.currentTimeMillis()));
    }
}
