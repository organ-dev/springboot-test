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

    public Result getPayById(Integer id) throws Exception {
        Result result = new Result();
        Pay pay = null;
        try {
            pay = payRepository.findOne(id);
            String ids = pay.getId().toString();
            result.setCode(ResultEnum.PAY_SUCCESS.getCode());
            result.setMsg(ResultEnum.PAY_SUCCESS.getMsg());
            result.setData(pay);
        } catch (Exception e) {
            throw new PayException(ResultEnum.PAY_ERROR);
        }
        return result;
    }
}
