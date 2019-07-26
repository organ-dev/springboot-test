package com.example.utils.watchUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;

/**
 * @Auther: ld
 * @Date: 2019/7/25 14:32
 * @Param ${tags}
 * @Description:
 */
public class CommonUtil {
	private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	protected CloseableHttpClient httpClient;
	private AccessTokenHolder accessTokenHolder;

	/**
	 * 发送https请求
	 *
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return rootNode(通过rootNode.get ( key)的方式获取json对象的属性值)
	 */
	public static JsonNode httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = {new MyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);
			//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			if ("GET".equalsIgnoreCase(requestMethod))
				conn.connect();

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			rootNode = mapper.readTree(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rootNode;
	}

	/**
	 * 获取接口访问凭证
	 *
	 * @param appid     凭证
	 * @param appsecret 密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String access_token_url, String appid, String appsecret) {
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		// 发起GET请求获取凭证
		JsonNode rootNode = httpsRequest(requestUrl, "GET", null);

		if (null != rootNode.get("access_token")) {
			accessToken = new AccessToken();
			accessToken.setAccessToken(rootNode.get("access_token").textValue());
			accessToken.setExpiresIn(toInt(rootNode.get("expires_in").toString()));
		}
		return accessToken;
	}

	/**
	 * 调用微信JS接口的临时票据
	 *
	 * @param access_token 接口访问凭证
	 * @return
	 */
	public static JsApiTicket getJsApiTicket(String jsapi_ticket_url, String access_token) {
		String requestUrl = jsapi_ticket_url.replace("ACCESS_TOKEN", access_token);
		// 发起GET请求获取凭证
		JsonNode rootNode = httpsRequest(requestUrl, "GET", null);
		JsApiTicket jsApiTicket = null;
		if (null != rootNode.get("ticket")) {
			jsApiTicket = new JsApiTicket();
			jsApiTicket.setTicket(rootNode.get("ticket").textValue());
			jsApiTicket.setExpiresIn(toInt(rootNode.get("expires_in").toString()));
		}
		return jsApiTicket;
	}

	public static Integer toInt(String str) {
		if (str == null || str.equals("")) {
			return null;
		}
		return Integer.valueOf(str);
	}

	private String httpPost(String url, String content) {
		HttpPost httpPost = new HttpPost(url);

		if (content != null) {
			StringEntity entity = new StringEntity(content, Consts.UTF_8);
			httpPost.setEntity(entity);
		}

		try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
			StatusLine statusLine = response.getStatusLine();
			HttpEntity entity = response.getEntity();
			if (statusLine.getStatusCode() >= 300) {
				EntityUtils.consume(entity);
				throw new WxRuntimeException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			}
			String responseContent = entity == null ? null : EntityUtils.toString(entity, Consts.UTF_8);

			WxError wxError = WxError.fromJson(responseContent);

			if (wxError.getErrorCode() != 0) {
				throw new WxRuntimeException(wxError);
			}
			return responseContent;
		} catch (IOException ex) {
			logger.error("http post: {} failed", url, ex);
			throw new WxRuntimeException(999, ex.getMessage());
		}
	}

	private String appendAccessToken(String url) {
		String token = accessTokenHolder.getAccessToken().getAccessToken();
		return url + (url.indexOf('?') == -1 ? "?access_token=" + token : "&access_token=" + token);
	}

	/***
	 * 公共调用微信接口方法
	 * @param url
	 * @param content
	 * @return
	 */
	public String post(String url, String content) {
		try {
			return httpPost(appendAccessToken(url), content);
		} catch (Exception e) {
			logger.error("公共调用微信接口方法 is fail:{}", e, e);
			throw new WxRuntimeException(999, e.getMessage());
		}
	}
}
