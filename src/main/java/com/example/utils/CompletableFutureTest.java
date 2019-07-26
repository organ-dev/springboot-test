package com.example.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: ld
 * @Date: 2019/6/24 14:12
 * @Param ${tags}
 * @Description:
 */
public class CompletableFutureTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<String> future = new CompletableFuture<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("CompletableFuture 可以监控这个任务");
				future.complete("任务返回");
			}
		}).start();
		System.out.println(future.get());
	}
}
