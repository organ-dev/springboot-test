package com.example.service;

import com.example.domain.Pay;
import com.example.domain.Result;
import com.example.enums.ResultEnum;
import com.example.exception.PayException;
import com.example.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Pay pay = null;
        pay = payRepository.findOne(id);
        //设置错误，查看日志
        String ids = pay.getId().toString();
        result.setCode(ResultEnum.PAY_SUCCESS.getCode());
        result.setMsg(ResultEnum.PAY_SUCCESS.getMsg());
        result.setData(pay);
        return result;
    }
}
