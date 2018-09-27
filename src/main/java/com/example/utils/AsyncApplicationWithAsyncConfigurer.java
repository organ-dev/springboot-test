package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auther: ld
 * @Date: 2018/9/27 13:55
 * @Description:
 */
@SpringBootApplication
@EnableAsync
public class AsyncApplicationWithAsyncConfigurer {
    private static final Logger log = LoggerFactory.getLogger(AsyncApplicationWithAsyncConfigurer.class);

    public static void main(String[] args) {
        log.info("Start AsyncApplication.. ");
        SpringApplication.run(AsyncApplicationWithAsyncConfigurer.class, args);
    }
}
