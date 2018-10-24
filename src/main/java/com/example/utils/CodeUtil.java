package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/10/24 15:32
 * @Description: 流水号不足6位前面加0, 每次递增加一
 */
public class CodeUtil {

    public String codeAddOne(String code, int len) {
        Integer num = Integer.parseInt(code);
        num++;
        String strNum = num.toString();
        while (strNum.length() < len) {
            strNum = "0" + strNum;
        }
        return strNum;
    }

    public static void main(String[] args) {
        CodeUtil testUtil = new CodeUtil();
        String str = testUtil.codeAddOne("111111", 6);
        System.out.println(str);
    }
}
