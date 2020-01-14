package com.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: boris
 * @Date: 2020-01-14 06:08
 * @Description: 线程顺序执行，两种方法：1、Thread.join(); 2、Executors.newSingleThreadExecutor()
 */
public class ThreadSequential {
    static Thread thread1 = new Thread(() -> {
        System.out.println("thread1");
    }, "thread1");
    static Thread thread2 = new Thread(() -> {
        System.out.println("thread2");
    }, "thread2");
    static Thread thread3 = new Thread(() -> {
        System.out.println("thread3");
    }, "thread3");

    static ExecutorService excutorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException {
        // 方案一
        // 通过join方法去保证多线程的顺序性的特性 wait
        // join：让主线程等待子线程结束以后才能继续运行
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();

        // 方案二
        // 队列的方式 FIFO
//        excutorService.submit(thread1);
//        excutorService.submit(thread2);
//        excutorService.submit(thread3);
//        excutorService.shutdown();
    }
}
