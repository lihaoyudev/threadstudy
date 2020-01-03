package com.threadstudy.chapter7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 每个1秒钟输出当前时间，被中断，观察。
 */
public class SleepInterrupted implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了！");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupted());
        thread.start();
        // 主线程休眠
        TimeUnit.SECONDS.sleep(6);
        thread.interrupt();
    }
}
