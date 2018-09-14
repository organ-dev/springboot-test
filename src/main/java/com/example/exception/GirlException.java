package com.example.exception;

import com.example.enums.ResultEnum;

/**
 * @Auther: ld
 * @Date: 2018/9/14 12:25
 * @Description: 继承runtimeException是可以事务回滚的
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
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
