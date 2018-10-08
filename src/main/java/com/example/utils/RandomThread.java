package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/10/8 09:33
 * @Description:
 */
public class RandomThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            RandomStringUtil randomStringUtil=new RandomStringUtil();
            System.out.println(randomStringUtil.randomString());
        }
    }

    public static void main(String[] args) {
        RandomThread randomThread = new RandomThread();
        Thread thread = new Thread(randomThread);
        thread.start();
    }
}
