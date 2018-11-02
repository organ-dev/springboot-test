package com.example.handle;

import com.example.domain.Result;
import com.example.enums.ResultEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Auther: ld
 * @Date: 2018/9/30 16:06
 * @Description: 校验
 */
public class ValidationUtil<T> {
    public Result ValidationUtil(T object) {

        Result result = new Result();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            result.setMsg(constraintViolation.getMessage());
            result.setCode(ResultEnum.PAY_ERROR.getCode());
            System.out.println("对象属性:" + constraintViolation.getPropertyPath());
            System.out.println("国际化key:" + constraintViolation.getMessageTemplate());
            System.out.println("错误信息:" + constraintViolation.getMessage());
        }
        return result;
    }
}
