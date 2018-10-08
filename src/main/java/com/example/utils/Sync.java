package com.example.utils;

/**
 * @Auther: ld
 * @Date: 2018/10/8 15:11
 * @Description:
 */
public class Sync {
    public void test() {
        synchronized (Sync.class) {
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
     static class MyThread extends Thread {

        public void run() {
            Sync sync = new Sync();
            sync.test();
        }
    }
}


