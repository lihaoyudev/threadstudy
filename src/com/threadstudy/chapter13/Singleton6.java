package com.threadstudy.chapter13;

/**
 * 双重检查（推荐面试使用）
 * volatile 1.可见性 2.防止重排序
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
