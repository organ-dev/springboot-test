package com.example.enums;

/**
 * Created by Aidon on 17/7/14.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "SUCCESS"),
    PRIMARY_SCHOOL(100, "小学"),
    MIDDLE_SCHOOL(101, "初中"),
    PAY_SUCCESS(1, "支付成功"),
    PAY_ERROR(2, "支付失败");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
