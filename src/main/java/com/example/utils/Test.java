package com.example.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: ld
 * @Date: 2018/11/13 09:21
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        String msg = getThreadTest();
        System.out.println(msg);
    }

    public static String getThreadTest() {
        String msg = "";
        int threadNum = 2;
        final CountDownLatch cdl = new CountDownLatch(threadNum);
        long starttime = System.currentTimeMillis();
        for (int k = 1; k <= threadNum; k++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Thread name=="+Thread.currentThread().getName());
                        for (int i = 0; i <= 10; i++) {
                            System.out.println("aa");
                        }
                    } catch (Exception e) {
                    } finally {
                        cdl.countDown();
                    }
                }
            }).start();
        }
        try {
            cdl.await();
            long spendtime = System.currentTimeMillis() - starttime;
            System.out.println(threadNum + "个线程花费时间:" + spendtime);
            msg = "更新成功!!!";
        } catch (InterruptedException e) {
            msg = "更新失败";
        }
        return msg;
    }
}
