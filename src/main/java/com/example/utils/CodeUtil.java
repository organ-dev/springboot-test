package com.example.utils;

import org.springframework.util.StringUtils;

/**
 * @Auther: ld
 * @Date: 2018/10/24 15:32
 * @Description: 流水号不足6位前面加0, 每次递增加一
 */
public class CodeUtil {
    private static String oldNum = "";

    public String codeAddOne(String code, int len) {
        Integer num=0;
        if(StringUtils.isEmpty(oldNum)){
            num= Integer.parseInt(code);
        }else{
            num= Integer.parseInt(oldNum);
        }
        num++;
        String strNum = num.toString();
        while (strNum.length() < len) {
            strNum = "0" + strNum;
        }
        return strNum;
    }

    public static void main(String[] args) {
        CodeUtil testUtil = new CodeUtil();
        for (int i = 0; i <5 ; i++) {
            String str = testUtil.codeAddOne("000123", 6);
            oldNum = str;
            System.out.println(str);
        }
    }
}
