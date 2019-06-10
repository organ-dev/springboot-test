package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2019/6/10 15:47
 * @Param ${tags}
 * @Description: 根据空格重新排序字符
 */
public class StringReverse {
	public static void main(String args[]) {
		String str1 = "I am a student!";

		System.out.println("原字符串：");

		System.out.println(str1);

		String str2 = reverse(str1);

		System.out.println("逆转后字符串：");

		System.out.println(str2);

	}

	public static String reverse(String str) {

		String[] strarray = str.split("\\s+");

		StringBuffer sbf = new StringBuffer();

		for (int i = strarray.length - 1; i >= 0; i--)

			sbf.append(strarray[i] + " ");

		return sbf.toString();

	}
}
