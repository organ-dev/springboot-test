package com.example.utils.sha1;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;

/**
 * @Auther: ld
 * @Date: 2019/9/2 17:02
 * @Param ${tags}
 * @Description:
 */
public class SecuritySHA1Utils {
	/**
	 * @return
	 * @Comment SHA1实现
	 * @Author Ron
	 * @Date 2017年9月13日 下午3:30:36
	 */
	public static String shaEncode(String inStr) throws Exception {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}

		byte[] byteArray = inStr.getBytes("UTF-8");
		byte[] md5Bytes = sha.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public static String encodePassword(String psw) {
		if (StringUtils.isEmpty(psw)) {
			return null;
		} else {
			return DigestUtils.sha1Hex(psw);
		}

	}

	public static void main(String args[]) throws Exception {
		String str = new String("admin");
		System.out.println("原始：" + str);
		System.out.println("SHA后：" + encodePassword(str));
	}

}
