package com.example.utils.test;

/**
 * @Auther: ld
 * @Date: 2019/6/20 17:43
 * @Param ${tags}
 * @Description:
 */
public class VolatileTest extends Thread {
	volatile boolean flag = false;//控制在主内存中取值
//	 boolean flag = false;
	int i = 0;

	public void run() {
		while (!flag) {
			i++;
		}
	}
	public static void main(String[] args) throws Exception {
		VolatileTest vt = new VolatileTest();
		vt.start();
		Thread.sleep(2000);
		vt.flag = true;
		System.out.println("stope" + vt.i);
	}
}
