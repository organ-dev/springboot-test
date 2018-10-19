package com.example.utils;


import org.apache.commons.codec.binary.Base64;

/**
 * @Auther: ld
 * @Date: 2018/10/19 09:45
 * @Description:
 */
public class SHA1Coding {
    public static void main(String[] args) {
        String pwd = "123";
        byte input[] = new byte[1024];
        String encPwd = null;
        try {
            input = pwd.getBytes();
            SHA1 sha1 = new SHA1();
            sha1.init();
            sha1.update(input, input.length);
            byte byEncoded[] = (new Base64()).encode(sha1.end());
            encPwd = new String(byEncoded);
            System.out.println(encPwd);
        } catch (Exception e) {

        }
    }
}
