package com.example.utils.watchUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: ld
 * @Date: 2019/7/25 13:47
 * @Param ${tags}
 * @Description: 获取token工具类
 */

public class GetTokenUtil {
	private static Logger logger = LoggerFactory.getLogger(GetTokenUtil.class);

//	@Scheduled(initialDelay = 10000, fixedRate = 15000)
	public String getTocken(String merId) {
		//根据商户id获取appid
		String appid = "wx1d610060c683754f";
		String secret = "2c66dc635d39a9b725e0fa4148dc0e80";
		String url = WxEndpoint.get("url.token.get");
		AccessToken accessToken = CommonUtil.getAccessToken(url, appid, secret);
		logger.info("accessToken:{}", accessToken.toString());
		return "";
	}
}
