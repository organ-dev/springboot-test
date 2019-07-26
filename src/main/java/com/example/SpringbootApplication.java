package com.example;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//@EnableJpaAuditing
@MapperScan("com.example.repository")
//@EnableConfigurationProperties({RedisSequences.class})
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BusinessSeqService.class}))//过滤掉不需要的类
@EnableScheduling//定时器
@EnableCaching//缓存
@EnableDubboConfiguration
@ServletComponentScan
@EnableTransactionManagement
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

	}
}




