package com.example.controller;

import com.example.exception.PayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dong_Liu
 * date：2017/10/16
 * 统一异常处理
 * 常见异常：https://blog.csdn.net/it666dhw/article/details/80505889
 */
@ControllerAdvice
public class MyControllerAdvice {
    private final static Logger log = LoggerFactory.getLogger(MyControllerAdvice.class);

    /**
     * 全局异常捕捉处理
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception e) {
        Map map = new HashMap();
        map.put("code", -1);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = PayException.class)
    @ResponseBody
    public Map handleBusinessException(PayException e) {
        Map map = new HashMap();
        map.put("code", -2);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map map = new HashMap();
        map.put("code", -3);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 空指针异常类型
     *
     * @auther: LiuDong
     * @date: 17:03 2018/9/14
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map NullPointerException(NullPointerException e) {
        Map map = new HashMap();
        map.put("code", -4);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 类型强制转换类型
     *
     * @auther: LiuDong
     * @date: 17:03 2018/9/14
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public Map ClassCastException(ClassCastException e) {
        Map map = new HashMap();
        map.put("code", -5);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }
}
