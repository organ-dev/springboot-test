package com.example.controller;

import com.example.utils.AsyncApplicationWithAnnotation;
import com.example.utils.AsyncApplicationWithAsyncConfigurer;
import com.example.utils.AsyncDemo;
import com.example.utils.AsyncExceptionDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Auther: ld
 * @Date: 2018/9/27 11:30
 * @Description:
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AsyncApplicationWithAnnotation.class)
@SpringBootTest
public class AsyncApplicationWithAnnotationTests {
    @Autowired
    private AsyncDemo asyncDemo;
    @Autowired
    private AsyncExceptionDemo asyncExceptionDemo;

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        for (int i = 0; i < 20; i++) {
            asyncDemo.asyncInvokeSimplest();
            asyncDemo.asyncInvokeWithParameter("test");
            Future<String> future = asyncDemo.asyncInvokeReturnFuture(100);
            System.out.println(future.get());
        }
    }

    @Test
    public void conExceptiontextLoads() throws InterruptedException, ExecutionException {
        asyncExceptionDemo.asyncInvokeSimplest();
        asyncExceptionDemo.asyncInvokeWithException("test");
        Future<String> future = asyncExceptionDemo.asyncInvokeReturnFuture(100);
        System.out.println(future.get());
    }
}
