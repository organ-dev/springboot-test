package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.domain.Pay;
import com.example.domain.Result;
import com.example.handle.ValidationUtil;
import com.example.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @PostMapping(value = "getPayById")
    public Result getPayById(@RequestParam("id") Integer id) {
        BeanUtils.copyProperties("", "");
        Result result = result = payService.getPayById(id);
        Pay pay = new Pay();
        System.out.println("msg" + JSONObject.toJSON(result));
        logger.info("pay日志{},附加日志：{}", JSONObject.toJSONString(result),JSONObject.toJSONString("2"));
        return result;
    }

    @PostMapping(value = "add")
    public Result addPay(@RequestBody Pay pay) {
        Result result = new Result();
        System.out.println(pay.toString());
        ValidationUtil validationUtil = new ValidationUtil();
        result = validationUtil.ValidationUtil(pay);
        if (StringUtils.isEmpty(result.getCode())) {
            result = payService.addPay(pay);
        }
        return result;
    }

    @GetMapping("/demo3")
    public void demo3(@RequestHeader(name = "myHeader") String myHeader) {
        System.out.println("myHeader=" + myHeader);

    }
}
