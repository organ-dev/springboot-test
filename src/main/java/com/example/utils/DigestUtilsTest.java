package com.example.utils;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * @Auther: ld
 * @Date: 2018/10/8 08:37
 * @Description:
 */
public class DigestUtilsTest {
    public String md5String(String str) {
        return DigestUtils.md5Hex(str);
    }

    public String sha1String(String str) {
        return DigestUtils.sha1Hex(str);
    }

    public static void main(String[] args) throws Exception{
        DigestUtilsTest digestUtilsTest = new DigestUtilsTest();
        System.out.println(digestUtilsTest.md5String("123"));
        System.out.println(digestUtilsTest.sha1String("123"));
        System.out.println(digestUtilsTest.sha1String("123"));
    }
}
