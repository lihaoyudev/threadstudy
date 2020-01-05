package com.threadstudy.chapter9;

/**
 * 单线程，抛出，处理，有异常堆栈 多线程，子线程发生异常，会有什么不同？
 * 子线程会继续抛出异常
 */
public class ExceptionInChildThread  implements Runnable{

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    @Override
    public void run() {
        throw new RuntimeException("子线程抛出的异常");
    }
}
