package com.threadstudy.chapter14;

/**
 * 转账时候遇到死锁，一旦打开注释，便会发生死锁
 */
public class TransferMoney implements Runnable{

    private int flag = 1;
    private static Account a = new Account(500);
    private static Account b = new Account(500);
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1, "线程1");
        Thread t2 = new Thread(r2, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.balance);
        System.out.println("b的余额" + b.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    private void transferMoney(Account from, Account to, int amount) {
        class Helper {
            public void transfer() {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                }
                from.balance -= amount;
                to.balance = to.balance + amount;
                System.out.println("成功转账" + amount + "元");
            }
        }

        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if (fromHash < toHash) {
            System.out.println(Thread.currentThread().getName() + "from < to");
            synchronized (from) {
                synchronized (to) {
                    new Helper().transfer();
                }
            }
        } else if (toHash < fromHash) {
            System.out.println(Thread.currentThread().getName() + "to < from");
            synchronized (to) {
                synchronized (from) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (lock) {
                synchronized (to) {
                    synchronized (from) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }


    static class Account {

        public Account(int balance) {
            this.balance = balance;
        }

        int balance;

    }
}
