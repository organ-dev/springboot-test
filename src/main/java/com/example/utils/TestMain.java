package com.example.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ld
 * @Date: 2018/10/18 11:45
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
       String str="0&amp;amp;amp;amp;nbsp;10&amp;amp;amp;amp;nbsp;0&amp;amp;amp;amp;nbsp;*&amp;amp;amp;amp;nbsp;*&amp;amp;amp;amp;nbsp;?";
       String a=str.replace("&amp;","").replace("amp;","").replace("nbsp;"," ");
        System.out.println(a);
    }
}
