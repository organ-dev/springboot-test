package com.example.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/3/20 09:27
 * @Param ${tags}
 * @Description: 定时任务
 * initialDelay 在容器启动后,延迟10秒后再执行
 * fixedRate 以后每15秒再执行一次该定时器
 */
@Component
public class PrintTask {
//@Scheduled(initialDelay = 10000,fixedRate = 15000)
public void cron() throws Exception{
//    Thread.sleep(2000);
    System.out.println("执行测试"+new Date(System.currentTimeMillis()));
    }
}
