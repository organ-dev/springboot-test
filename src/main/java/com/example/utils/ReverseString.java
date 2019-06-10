package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2019/6/10 16:22
 * @Param ${tags}
 * @Description: 倒叙输出
 */
public class ReverseString {
	public static void main(String[] args) {
		String s = "12345abc";
		ReverseString stringTest = new ReverseString();
		stringTest.reverseString1(s);
	}
	/*
	 * string倒序输出
	 * 利用String类的toCharArray()，再倒序输出数组的方法
	 * 2018-5-18 13:05:00
	 */
	private static void reverseString1(String str) {

		char[] chr = str.toCharArray();

		for (int i = chr.length-1 ; i >= 0; i--) {
			System.out.print(chr[i]);
		}
		System.out.println("\t");

	}

	private static void reverseString2(String str) {

		if (str.length() == 1)
			System.out.println(str);
		else {
			String subString1 = str.substring(0, str.length() - 1);
			String subString2 = str.substring(str.length() - 1);

			System.out.print(subString2);

			reverseString2(subString1);
		}
	}
	/*
	 * string倒序输出
	 * 定义成一个StringBuffer类，用StringBuffer类中的reverse()方法直接倒序字符串。
	 * 2018-5-18 13:22:10
	 */
	private static void reverseString3(String str) {

		StringBuffer buffer = new StringBuffer(str);
		System.out.println(buffer.reverse());

	}

}
