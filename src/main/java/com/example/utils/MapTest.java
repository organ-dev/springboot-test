package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ld
 * @Date: 2018/10/18 11:41
 * @Description:
 */
public class MapTest {
    private String phoneMap[] = {"a", "b"};

    public String[] getPhoneMap() {
        if (1 == 1) {
            String arr[] = {"aa", "bb"};
            phoneMap = arr;
        }
        return phoneMap;
    }

    public void setPhoneMap(String[] phoneMap) {
        this.phoneMap = phoneMap;
    }

    public static void main(String[] args) {


    }
}
