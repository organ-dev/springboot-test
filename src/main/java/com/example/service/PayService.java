package com.example.service;

import com.example.domain.Pay;
import com.example.domain.Result;
import com.example.enums.ExceptionEnums;
import com.example.enums.ResultEnum;
import com.example.exception.PayException;
import com.example.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * @Auther: ld
 * @Date: 2018/9/14 14:50
 * @Description:
 */
@Service
public class PayService {
    @Autowired
    private PayRepository payRepository;

    public Result getPayById(Integer id) {
        Result result = new Result();
        Pay pay = payRepository.findOne(id);
        //设置错误，查看日志
//        userService.getUserTest();
        try {
            result.setCode(ResultEnum.PAY_SUCCESS.getCode());
            result.setMsg(ResultEnum.PAY_SUCCESS.getMsg());
            result.setData(pay);
        } catch (Exception e) {
            throw new PayException(ExceptionEnums.PAY_ERROR);
        }
        return result;
    }

    public Result addPay(Pay pay) {
        Result result = new Result();
        Pay ResultPay = payRepository.saveAndFlush(pay);
        if (null != ResultPay.getId()) {
            result.setCode(ResultEnum.PAY_SUCCESS.getCode());
            result.setMsg(ResultEnum.PAY_SUCCESS.getMsg());
            result.setData(pay);
        } else {
            result.setCode(ResultEnum.PAY_ERROR.getCode());
            result.setMsg(ResultEnum.PAY_ERROR.getMsg());
            result.setData(pay);
        }
        return result;
    }
}
