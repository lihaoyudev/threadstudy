package com.threadstudy.chapter4;

public class CannotStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

    }
}
