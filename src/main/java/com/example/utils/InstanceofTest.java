package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/11/1 10:44
 * @Description:
 */
public class InstanceofTest {
    public static void main(String[] args) {
        if(null instanceof Object){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        String obj=null;
        if(obj instanceof Object){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
