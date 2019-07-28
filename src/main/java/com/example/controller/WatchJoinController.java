package com.example.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.watchUtil.CommonUtil;
import com.example.utils.watchUtil.WxEndpoint;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ld
 * @Date: 2019/7/26 18:29
 * @Param ${tags}
 * @Description: 修改会员卡信息：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1451025272
 */
@RestController
@RequestMapping(value = "/watchJoin")
public class WatchJoinController {
    private static Logger logger = LoggerFactory.getLogger(WatchJoinController.class);

    /**
     * 功能描述:更新会员卡信息,用于微信端修改用户余额
     * 出发情况：用户消费，用户线下充值
     *
     * @param:card_id,code,balance
     * @return:
     * @auther: LiuDong
     * @date: 18:33 2019/7/26
     */
    @RequestMapping(value = "/updateMemberInfo")
    public String updateMemberInfo(@RequestBody String para) {
        logger.info("更新会员卡信息 data:{}", para);
        try {
            BigDecimal balance = new BigDecimal("50.00");
            JSONObject obj = JSONObject.parseObject(para);
            String updateuser = WxEndpoint.get("url.card.membercard.updateuser");
            //TODO 拼装需要修改的用户信息、下订单、记录流水（类型注意）
            //获取token值
            String token = "23_IF2KKjyalacK8-trcBMnJTQy1pR-NHcg2uKx_mu4XY0CY9HjHPFIKqcxRfuTAL2CFf216Ry2oXa20SDcnKE0c4mFILfP8lLIarJZFCqZXpByCKcGOozJORuNvI7sn08DBYx9IKJ8QTqQeNvfTYTeAHAOTO";
            //调用更新接口，需判断传递参数是否正确card_id和code不为空，需要计算余额总值

            if (StringUtils.isEmpty(obj.getString("card_id")) || StringUtils.isEmpty(obj.getString("code"))) {
                return "参数错误。";
            } else {
                Map<String, String> paraMap = new HashMap<>();
                paraMap.put("card_id", obj.getString("card_id"));
                paraMap.put("code", obj.getString("code"));
                //TODO 需要计算余额
                BigDecimal addBalance = new BigDecimal(obj.getString("add_balance"));
                if (Integer.valueOf(addBalance.toString()) < 0) {

                    balance = balance.subtract(BigDecimal.ZERO.subtract(addBalance));
                } else {
                    balance = balance.add(addBalance);
                }
                paraMap.put("balance", String.valueOf(balance));
                paraMap.put("add_balance", obj.getString("add_balance"));
                paraMap.put("record_balance", obj.getString("record_balance"));//备注
                String outputStr = JSONObject.toJSONString(paraMap);
                String requestUrl = updateuser.replace("TOKEN", token);
                JsonNode rootNode = CommonUtil.httpsRequest(requestUrl, "POST", outputStr);
                System.out.println("rootNode====" + rootNode);
            }
        } catch (Exception e) {
            logger.error("更新会员卡信息 is fail", e, e);
        }
        return "";
    }

    /**
     * 功能描述:会员卡开卡后，设置激活时开卡字段
     * 出发情况：用户成为会员时，需填写的字段
     *
     * @param:
     * @return:
     * @auther: LiuDong
     * @date: 18:33 2019/7/28
     */
    @RequestMapping(value = "/activateUserFormSet")
    public String activateUserFormSet(@RequestBody String para) {
        logger.info("activateUserFormSet card_id=" + para);

        return "";
    }
}
