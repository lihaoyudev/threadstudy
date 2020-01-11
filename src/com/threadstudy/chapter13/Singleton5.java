package com.threadstudy.chapter13;

/**
 * 懒汉式（线程不安全）（不推荐）
 */
public class Singleton5 {
    private static Singleton5 instance;

    public Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
