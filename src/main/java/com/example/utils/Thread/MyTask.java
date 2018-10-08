package com.example.utils.Thread;

/**
 * @Auther: ld
 * @Date: 2018/10/8 09:50
 * @Description:
 */
public class MyTask implements Runnable {
    private int taskNum;

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }

    public MyTask(int num) {
        this.taskNum = num;
    }

}
