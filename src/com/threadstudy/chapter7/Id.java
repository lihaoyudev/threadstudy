package com.threadstudy.chapter7;

/**
 * ID从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是2.
 */
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(Thread.currentThread().getId());
        System.out.println(thread.getId());
    }
}
