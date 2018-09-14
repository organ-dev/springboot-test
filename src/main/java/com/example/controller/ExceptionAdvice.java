package com.example.controller;

import com.example.exception.PayException;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dong_Liu
 * date：2017/10/16
 * 统一异常处理
 * 常见异常：https://blog.csdn.net/it666dhw/article/details/80505889
 */
@ControllerAdvice
public class ExceptionAdvice {
    private final static Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

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

    /**
     * 功能描述:数组下标越界异常
     *
     * @auther: LiuDong
     * @date: 17:06 2018/9/14
     */
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    @ResponseBody
    public Map ArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        Map map = new HashMap();
        map.put("code", -6);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 文件未找到异常
     *
     * @auther: LiuDong
     * @date: 17:09 2018/9/14
     */
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseBody
    public Map FileNotFoundException(FileNotFoundException e) {
        Map map = new HashMap();
        map.put("code", -7);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 文件已结束异常
     *
     * @auther: LiuDong
     * @date: 17:09 2018/9/14
     */
    @ExceptionHandler(EOFException.class)
    @ResponseBody
    public Map EOFException(EOFException e) {
        Map map = new HashMap();
        map.put("code", -8);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 字符串转换为数字异常
     *
     * @auther: LiuDong
     * @date: 17:10 2018/9/14
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public Map NumberFormatException(NumberFormatException e) {
        Map map = new HashMap();
        map.put("code", -9);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 操作数据库异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Map SQLException(SQLException e) {
        Map map = new HashMap();
        map.put("code", -10);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 操作数据库异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Map IOException(IOException e) {
        Map map = new HashMap();
        map.put("code", -11);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 方法未找到异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public Map NoSuchMethodException(NoSuchMethodException e) {
        Map map = new HashMap();
        map.put("code", -12);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 系统异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public Map SystemException(SystemException e) {
        Map map = new HashMap();
        map.put("code", -13);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 创建一个大小为负数的数组错误异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(NegativeArraySizeException.class)
    @ResponseBody
    public Map NegativeArraySizeException(NegativeArraySizeException e) {
        Map map = new HashMap();
        map.put("code", -14);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 安全异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(SecurityException.class)
    @ResponseBody
    public Map SecurityException(SecurityException e) {
        Map map = new HashMap();
        map.put("code", -15);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 不支持的操作异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseBody
    public Map UnsupportedOperationException(UnsupportedOperationException e) {
        Map map = new HashMap();
        map.put("code", -16);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 请求状态异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public Map IllegalStateException(IllegalStateException e) {
        Map map = new HashMap();
        map.put("code", -17);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 反射Method.invoke(obj, args...)方法抛出异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(InvocationTargetException.class)
    @ResponseBody
    public Map InvocationTargetException(InvocationTargetException e) {
        Map map = new HashMap();
        map.put("code", -18);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

    /**
     * 功能描述: 非法参数异常
     *
     * @auther: LiuDong
     * @date: 17:11 2018/9/14
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Map IllegalArgumentException(IllegalArgumentException e) {
        Map map = new HashMap();
        map.put("code", -19);
        map.put("msg", e.getMessage());
        map.put("data", null);
        log.error("系统错误 {}", e.getMessage());
        return map;
    }

}
