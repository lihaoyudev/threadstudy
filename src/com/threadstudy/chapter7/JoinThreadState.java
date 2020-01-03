package com.threadstudy.chapter7;

/**
 * 先join再mainThread.getState()
 * 通过debugger看线程join前后状态的对比
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程join运行时主线程状态" + mainThread.getState()); // WAITING
                    System.out.println("Thread-0运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        System.out.println("子线程join前主线程状态：" + mainThread.getState());
        thread.join();
        System.out.println("子线程运行完毕");
    }
}
