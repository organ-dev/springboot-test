package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.watchPay.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		//TODO 获取到会员卡审核返回结果，更新会员卡信息
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
	@RequestMapping(value = "/watchPayCallBack")
	public void watchPayCallBack() {

	}
}
