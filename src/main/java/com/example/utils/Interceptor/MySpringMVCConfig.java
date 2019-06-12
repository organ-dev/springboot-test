package com.example.utils.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: ld
 * @Date: 2019/6/12 16:44
 * @Param ${tags}
 * @Description:
 */
@SpringBootConfiguration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private UserConfig userConfig;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//自定义访问的controller类
		registry.addInterceptor(userConfig).addPathPatterns("/**");
	}
}
