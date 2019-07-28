package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.watchPay.WXPayUtil;
import com.example.utils.watchUtil.Res;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: ld
 * @Date: 2019/7/26 10:19
 * @Param ${tags}
 * @Description: 微信平台回调接口
 */
@RestController
@RequestMapping(value = "/watchRequest")
public class WatchCallBackController {
	private static Logger logger = LoggerFactory.getLogger(WatchCallBackController.class);

	/**
	 * 功能描述: 微信平台服务器配置接口
	 *
	 * @param:
	 * @return:
	 * @auther: LiuDong
	 * @date: 10:59 2019/7/26
	 */
	@RequestMapping(value = "/watchCallBack")
	public void watchCallBack(@RequestBody String requestMsg) {

		Map<String, String> xmlRequest = null;
		try {
			xmlRequest = WXPayUtil.xmlToMap(requestMsg);
			switch (xmlRequest.get("MsgType")) {
				case "card_pass_check":
					//审核事件推送
					this.cardPassCheck(xmlRequest);
				case "user_get_card":
					//领取事件推送
					this.userGetCard(xmlRequest);
				case "user_del_card":
					//删除事件推送

				case "user_consume_card":
					//核销事件推送

				case "update_member_card":
					//会员卡内容更新事件
					this.updateMemberCard(xmlRequest);
				case "submit_membercard_user_info":
					//会员卡激活事件推送
					this.submitMembercardUserInfo(xmlRequest);
				default:
					logger.info("微信平台服务器配置地址 返回的事件：{}，data:{}", xmlRequest.get("MsgType"), JSONObject.toJSONString(requestMsg));
					System.out.println("成功");
			}
		} catch (Exception e) {
			logger.error("微信平台服务器配置接口 watchCallBack is fail:{}", e, e);
			System.out.println(e);
		}

	}

	/**
	 * 功能描述:审核事件推送
	 *
	 * @param: xmlRequest
	 * @return:
	 * @auther: LiuDong
	 * @date: 13:37 2019/7/26
	 */
	public void cardPassCheck(Map<String, String> xmlRequest) {
		// TODO 获取到会员卡审核返回结果，更新会员卡信息
		String toUserName = xmlRequest.get("ToUserName");//开发者微信号
		String fromUserName = xmlRequest.get("FromUserName");//发送方帐号（一个OpenID）
		String createTime = xmlRequest.get("CreateTime");//消息创建时间 （整型）
		String msgType = xmlRequest.get("MsgType");//消息类型，event
		String cardId = xmlRequest.get("CardId");//卡券ID
		String refuseReason = xmlRequest.get("RefuseReason");//审核不通过原因
		//根据
	}

	/**
	 * 功能描述:领取事件推送
	 *
	 * @param: xmlRequest
	 * @return:
	 * @auther: LiuDong
	 * @date: 13:37 2019/7/26
	 */
	public void userGetCard(Map<String, String> xmlRequest) {
		// TODO 会员扫码后，微信推送会员领卡事件。接收到信息后对会员信息进行操作
		String toUserName = xmlRequest.get("ToUserName");//开发者微信号
		String fromUserName = xmlRequest.get("FromUserName");//发送方帐号（一个OpenID）
		String createTime = xmlRequest.get("CreateTime");//消息创建时间 （整型）
		String msgType = xmlRequest.get("MsgType");//消息类型，event
		String cardId = xmlRequest.get("CardId");//卡券ID
		String userCardCode = xmlRequest.get("UserCardCode");
		String unionId = xmlRequest.get("UnionId");
	}

	/**
	 * 功能描述:会员卡内容更新事件
	 *
	 * @param: xmlRequest
	 * @return:
	 * @auther: LiuDong
	 * @date: 13:37 2019/7/26
	 */
	public void updateMemberCard(Map<String, String> xmlRequest) {
		String toUserName = xmlRequest.get("ToUserName");//开发者微信号
		String fromUserName = xmlRequest.get("FromUserName");//发送方帐号（一个OpenID）
		String createTime = xmlRequest.get("CreateTime");//消息创建时间 （整型）
		String msgType = xmlRequest.get("MsgType");//消息类型，event
		String cardId = xmlRequest.get("CardId");//卡券ID
		String userCardCode = xmlRequest.get("UserCardCode");
		String modifyBonus = xmlRequest.get("ModifyBonus");
		String modifyBalance = xmlRequest.get("ModifyBalance");
	}

	/**
	 * 功能描述:会员卡激活事件推送
	 *
	 * @param: xmlRequest
	 * @return:
	 * @auther: LiuDong
	 * @date: 13:37 2019/7/26
	 */
	public void submitMembercardUserInfo(Map<String, String> xmlRequest) {
		String toUserName = xmlRequest.get("ToUserName");//开发者微信号
		String fromUserName = xmlRequest.get("FromUserName");//发送方帐号（一个OpenID）
		String createTime = xmlRequest.get("CreateTime");//消息创建时间 （整型）
		String msgType = xmlRequest.get("MsgType");//消息类型，event
		String cardId = xmlRequest.get("CardId");//卡券ID
		String userCardCode = xmlRequest.get("UserCardCode");
	}

	/**
	 * 功能描述: 微信支付回调接口
	 *
	 * @param:
	 * @return:
	 * @auther: LiuDong
	 * @date: 11:00 2019/7/26
	 */
	@RequestMapping(value = "/watchPayNotify")
	public Res watchPayCallBack(HttpServletRequest request) {
		String result;//返回给微信的处理结果
		String inputLine;
		String notityXml = "";
		try {
			request.setCharacterEncoding("UTF-8");
			while ((inputLine = request.getReader().readLine()) != null) {
				notityXml += inputLine;
			}
			request.getReader().close();
			logger.info("微信支付回调接口 data:{}" + JSONObject.toJSONString(notityXml));
			Map map = WXPayUtil.xmlToMap(notityXml);
			// 解析各种数据
			String appid = (String) map.get("appid");//应用ID
			String attach = (String) map.get("attach");//商家数据包
			String bank_type = (String) map.get("bank_type");//付款银行
			String cash_fee = (String) map.get("cash_fee");//现金支付金额
			String fee_type = (String) map.get("fee_type");//货币种类
			String is_subscribe = (String) map.get("is_subscribe");//是否关注公众账号
			String mch_id = (String) map.get("mch_id");//商户号
			String nonce_str = (String) map.get("nonce_str");//随机字符串
			String openid = (String) map.get("openid");//用户标识
			String out_trade_no = (String) map.get("out_trade_no");// 获取商户订单号
			String result_code = (String) map.get("result_code");// 业务结果
			String return_code = (String) map.get("return_code");// SUCCESS/FAIL
			String sign = (String) map.get("sign");// 获取签名
			String time_end = (String) map.get("time_end");//支付完成时间
			String total_fee = (String) map.get("total_fee");// 获取订单金额
			String trade_type = (String) map.get("trade_type");//交易类型
			String transaction_id = (String) map.get("transaction_id");//微信支付订单号

			if (("SUCCESS").equals(result_code)) {
				Map msg = new HashMap<String, String>();
				msg.put("return_code", "SUCCESS");
				msg.put("return_msg", "OK");
				result = WXPayUtil.mapToXml(msg);
			} else {
				Map msg = new HashMap<String, String>();
				msg.put("return_code", "fail");
				msg.put("return_msg", "微信返回的交易状态不正确（result_code=" + result_code + "）");
				result = WXPayUtil.mapToXml(msg);
				logger.error("微信返回的交易状态不正确（result_code=" + result_code + "）");
			}
			// 如果微信返回的结果是success，则修改订单状态
			if (("SUCCESS").equals(return_code)) {
				Map msg = new HashMap<String, String>();
				msg.put("return_code", "SUCCESS");
				msg.put("return_msg", "OK");
				result = WXPayUtil.mapToXml(msg);
				//TODO 修改流水信息、修改订单信息、修改商户金额、调用用户信息修改接口


			} else {
				Map msg = new HashMap<String, String>();
				msg.put("return_code", "fail");
				msg.put("return_msg", return_code);
				result = WXPayUtil.mapToXml(msg);
			}
			logger.info("微信支付回调接口,返回给微信的xml：" + result);
			return Res.Success(result);
		} catch (Exception e) {
			logger.error("message:" + e.getMessage());
			Map msg = new HashMap<String, String>();
			msg.put("return_code", "fail");
			msg.put("return_msg", "xml获取失败");
			try {
				result = WXPayUtil.mapToXml(msg);
			} catch (Exception e1) {
			}
		}
		if (StringUtils.isEmpty(notityXml)) {
			Map msg = new HashMap<String, String>();
			msg.put("return_code", "fail");
			msg.put("return_msg", "xml为空");
			try {
				result = WXPayUtil.mapToXml(msg);
			} catch (Exception e) {
			}
		}
		return Res.Failure(Res.Failure, "订单支付失败！");
	}

}
