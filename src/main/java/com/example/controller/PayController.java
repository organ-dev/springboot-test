package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Pay;
import com.example.domain.Result;
import com.example.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: ld
 * @Date: 2018/9/14 14:54
 * @Description:
 */
@RestController
@RequestMapping(value = "pay")
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping(value = "getPayById")
    public Result getPayById(@RequestParam("id") Integer id) {
        BeanUtils.copyProperties("", "");
        Result result = result = payService.getPayById(id);
        Pay pay = new Pay();
        System.out.println("msg"+JSONObject.toJSON(result));
        return result;
    }
}
