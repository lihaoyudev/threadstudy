package com.threadstudy.chapter5.volatiledemo;

/**
 * 演示用volatile的局限：part1 看似可行
 */
public class WrongWayVolatile implements Runnable{

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000 && !canceled) {
                if (num % 1000 == 0) {
                    System.out.println(num + "是100的倍数。");
                }
                num ++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile runnable = new WrongWayVolatile();
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        runnable.canceled = true;
    }
}
