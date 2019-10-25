package com.example.utils;

import com.google.common.collect.Maps;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * @Auther: ld
 * @Date: 2018/10/12 10:35
 * @Description:
 */
public class MD5Tools {
	/***
	 * MD5加码 生成32位md5码
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}

	/**
	 * 功能描述: MD564位加密
	 *
	 * @param:
	 * @return:
	 * @auther: LiuDong
	 * @date: 14:52 2019/10/25
	 */
	private static String md5Encode(String str) {
		String bs64 = new String();
		BASE64Encoder encoder = new BASE64Encoder();
		try {
			// 加密对象，指定加密方式
			MessageDigest md5 = MessageDigest.getInstance("md5");
			// 准备要加密的数据
			byte[] b = str.getBytes();
			// 加密
			byte[] digest = md5.digest(b);
			// 十六进制的字符
			char[] chars = new char[]{'0', '1', '2', '3', '4', '5',
					'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			StringBuffer sb = new StringBuffer();
			// 处理成十六进制的字符串(通常)
			for (byte bb : digest) {
				sb.append(chars[(bb >> 4) & 15]);
				sb.append(chars[bb & 15]);
			}
			bs64 = encoder.encode(sb.toString().getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return bs64;
	}
	/**
	 * 根据map的key排序
	 *
	 * @param map    待排序的map
	 * @param isDesc 是否降序，true：降序，false：升序
	 * @return 排序好的map
	 * @author zero 2019/04/08
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
		Map<K, V> result = Maps.newLinkedHashMap();
		if (isDesc) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
					.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		} else {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
					.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		}
		return result;
	}

	// 测试主函数
	public static void main(String args[]) {
		String s = new String("17603086661");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + string2MD5(s));
		System.out.println("加密的：" + convertMD5(s));
		System.out.println("解密的：" + convertMD5(convertMD5(s)));

	}

}
