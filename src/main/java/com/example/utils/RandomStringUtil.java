package com.example.utils;


import org.apache.commons.lang.RandomStringUtils;

/**
 * @Auther: ld
 * @Date: 2018/10/8 09:11
 * @Description:
 */
public class RandomStringUtil {
    /**
     * count 创建一个随机字符串，其长度是指定的字符数,字符将从参数的字母数字字符集中选择，如参数所示。
     * letters true,生成的字符串可以包括字母字符
     * numbers true,生成的字符串可以包含数字字符
     */
    public String getRandomString() {
        String random = "";
        random= RandomStringUtils.random(15,true,false);
        return random;
    }
    /**
     * 创建一个随机字符串，其长度是指定的字符数。
     * 字符将从字符串指定的字符集中选择，不能为空。如果NULL，则使用所有字符集。
     */
    public String randomString(){
        String random = "";
        random = RandomStringUtils.random(15, "abcdefgABCDEFG123456789");
        return random;
    }
    /**
     * 产生一个长度为指定的随机字符串的字符数，字符将从拉丁字母（a-z、A-Z的选择）。
     * count:创建随机字符串的长度
     */
    public String randomAlphabetic(){
        String random = "";
        random =RandomStringUtils.randomAlphabetic(5);
        return random;
    }

    public static void main(String[] args) {
        RandomStringUtil randomStringUtil=new RandomStringUtil();
        System.out.println(randomStringUtil.getRandomString());
        System.out.println(randomStringUtil.randomString());
        System.out.println(randomStringUtil.randomAlphabetic());
    }
}
