package com.threadstudy.chapter7;

/**
 * 两个线程交替打印0~100的奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEveWait {

    private int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TurningRunner runner = new WaitNotifyPrintOddEveWait().new TurningRunner();
        new Thread(runner, "偶数").start();
        new Thread(runner, "奇数").start();

    }

    class TurningRunner implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
