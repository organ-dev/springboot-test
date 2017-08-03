package com.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Aidon on 17/7/14.
 */
@Aspect
@Component
public class HttpAspect {
    //记录日志
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        LOGGER.info("url={}", request.getRequestURL());
        //method
        LOGGER.info("method={}", request.getMethod());
        //ip
        LOGGER.info("ip={}", request.getRemoteAddr());
        //类方法
        LOGGER.info("class_method={}", joinpoint.getSignature().getDeclaringTypeName()
                + "." + joinpoint.getSignature().getName());
        //参数
        LOGGER.info("agrs={}", joinpoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
        LOGGER.info("after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object object) {
        LOGGER.info("response={}", object.toString());
    }
}
