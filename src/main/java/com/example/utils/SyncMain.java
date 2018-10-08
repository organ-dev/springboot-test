package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/10/8 15:13
 * @Description:
 */
public class SyncMain {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Sync.MyThread();
            thread.start();
        }
    }
}
