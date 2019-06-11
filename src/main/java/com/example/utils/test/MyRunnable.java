package com.example.utils.test;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ld
 * @Date: 2019/6/3 15:26
 * @Param ${tags}
 * @Description:
 */
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + "-------------进入");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(currentThread.getName() + "-------------离开");
		}

	}
}
