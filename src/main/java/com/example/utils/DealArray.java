package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/11/2 16:18
 * @Description:
 */
public class DealArray {
    public  void getDealArray(int... intArray) {
        for (int a : intArray
        ) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        DealArray dealArray=new DealArray();
        dealArray.getDealArray(1,2,3,4,5,6);
    }
}
