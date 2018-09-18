package com.example.exception;

import com.example.enums.ExceptionEnums;
import com.example.enums.ResultEnum;

/**
 * @Auther: ld
 * @Date: 2018/9/14 14:43
 * @Description:
 */
public class PayException extends RuntimeException {
    private Integer code;

    public PayException(ExceptionEnums resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
