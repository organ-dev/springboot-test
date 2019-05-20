package com.example;

import com.example.utils.seq.RedisSequences;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

//@ComponentScan
@SpringBootApplication
//@EnableJpaAuditing
//@MapperScan("com.example.repository")
//@EnableConfigurationProperties({RedisSequences.class})
@EnableScheduling
@EnableCaching
public class SpringbootApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringbootApplication.class,args);

    }
}




