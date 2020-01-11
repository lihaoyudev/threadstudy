package com.threadstudy.chapter14;

/**
 * 必定发生死锁的情况
 */
public class MustDeadLock implements Runnable {

    private int flag = 1;

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 0;
        Thread thread1 = new Thread(r1, "线程1");
        Thread thread2 = new Thread(r2, "线程2");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("flag:" + flag);
        if (flag == 1) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "拿到O1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "成功拿到两把锁");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "拿到O2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "成功拿到两把锁");
                }
            }
        }
    }
}
