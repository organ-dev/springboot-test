package com.example.enums;

/**
 * @Auther: ld
 * @Date: 2018/9/14 17:44
 * @Description:
 */
public enum ExceptionEnums {
    EXCEPTION(-1, "系统异常"),
    METHODARGUMENTNOTVALIDEXCEPTION(-2, "接口数据验证异常"),
    NULLPOINTEREXCEPTION(-3, "空指针异常类型"),
    CLASSCASTEXCEPTION(-4, "类型强制转换类型"),
    ARRAYINDEXOUTOFBOUNDSEXCEPTION(-5, "数组下标越界异常"),
    FILENOTFOUNDEXCEPTION(-6, "文件未找到异常"),
    EOFEXCEPTION(-7, "文件已结束异常"),
    NUMBERFORMATEXCEPTION(-8, "字符串转换为数字异常"),
    SQLEXCEPTION(-9, "操作数据库异常"),
    IOEXCEPTION(-10, "操作数据库异常"),
    NOSUCHMETHODEXCEPTION(-11, "方法未找到异常"),
    SYSTEMEXCEPTION(-12, "系统异常"),
    NEGATIVEARRAYSIZEEXCEPTION(-13, "创建一个大小为负数的数组错误异常"),
    SECURITYEXCEPTION(-14, "安全异常"),
    UNSUPPORTEDOPERATIONEXCEPTION(-15, "不支持的操作异常"),
    ILLEGALSTATEEXCEPTION(-16, "请求状态异常"),
    INVOCATIONTARGETEXCEPTION(-17, "反射异常"),
    ILLEGALARGUMENTEXCEPTION(-18, "非法参数异常"),
    PAY_ERROR(-19, "支付系统异常"),
    TIMEOUTEXCEPTION(-20, "访问超时");
    private Integer code;
    private String msg;

    ExceptionEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
