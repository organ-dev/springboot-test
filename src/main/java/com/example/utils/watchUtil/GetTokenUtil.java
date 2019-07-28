package com.example.utils.watchUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述:定时任务获取商户的token，保存或更新token
 *
 * @param:card_id,code,balance
 * @return:
 * @auther: LiuDong
 * @date: 18:33 2019/7/26
 */

public class GetTokenUtil {
	private static Logger logger = LoggerFactory.getLogger(GetTokenUtil.class);

//	@Scheduled(initialDelay = 10000, fixedRate = 15000)
	public void getTocken() {
		//查询访问令牌表，判断token为空时进行主动查询token
		try {
			String appid = "wx1d610060c683754f";
			String secret = "2c66dc635d39a9b725e0fa4148dc0e80";
			String url = WxEndpoint.get("url.token.get");

			AccessToken accessToken = CommonUtil.getAccessToken(url, appid, secret);
			logger.info("accessToken:{}", accessToken.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
