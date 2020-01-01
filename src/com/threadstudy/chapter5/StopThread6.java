package com.threadstudy.chapter5;

/**
 * 错误停止线程方法（模拟军队发放武器）
 * 用stop()来停止线程，会导致线程运行一半突然停止，没办法完成一个基本单位的操作（一个连队），
 * 会造成脏数据（有的连队多领取少领取装备）。
 */
public class StopThread6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队"+i+"已经领取完毕");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread6());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
