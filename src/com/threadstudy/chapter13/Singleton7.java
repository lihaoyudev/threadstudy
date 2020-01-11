package com.threadstudy.chapter13;

/**
 * 静态内部类方式，可用
 */
public class Singleton7 {

    private Singleton7() {
    }

    private static class SingletonInstance {
        private static Singleton7 instance = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.instance;
    }
}
