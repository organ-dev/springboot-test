package com.example.utils;

import com.example.utils.Thread.MyTask;

import java.util.concurrent.*;

/**
 * @Auther: ld
 * @Date: 2019/3/29 17:29
 * @Param ${tags}
 * @Description: 线程池使用
 */
public class ThreadPololTest {
    private static ExecutorService saveThreadPool = new ThreadPoolExecutor(2, 40, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(50000), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
    }

}
