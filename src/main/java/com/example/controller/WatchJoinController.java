package com.example.controller;

import com.example.utils.watchUtil.WxEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ld
 * @Date: 2019/7/26 18:29
 * @Param ${tags}
 * @Description:
 */
@RestController
@RequestMapping(value = "/watchJoin")
public class WatchJoinController {
	private static Logger logger = LoggerFactory.getLogger(WatchJoinController.class);

	/**
	 * 功能描述:更新会员卡信息
	 *
	 * @param:
	 * @return:
	 * @auther: LiuDong
	 * @date: 18:33 2019/7/26
	 */
	@RequestMapping(value = "/updateMemberInfo")
	public String updateMemberInfo(@RequestBody String requestMsg) {
		logger.info("更新会员卡信息 data:{}", requestMsg);
		try {
			String url = WxEndpoint.get("url.card.membercard.updateuser");
			//TODO 拼装需要修改的用户信息、下订单、记录流水（类型注意）

		} catch (Exception e) {
			logger.error("更新会员卡信息 is fail", e, e);
		}
		return "";
	}
}
