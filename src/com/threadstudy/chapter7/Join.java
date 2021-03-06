package com.threadstudy.chapter7;

/**
 * 演示join，注意语句输出顺序，会变化。
 * 主线程等待子线程.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        }, "线程1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        }, "线程2");
        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程执行完");
        thread1.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
