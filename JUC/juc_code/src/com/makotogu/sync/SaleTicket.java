package com.makotogu.sync;
// 创建资源类，定义熟悉和操作方法
class Ticket {
    // 票数
    private int num = 100;
    // 操作方法--卖票
    synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + " :卖出: "+ (num--) + " 剩下:" + num);
        }
    }
}

public class SaleTicket {
    // 第二步 创建多个线程，都调用资源类的操作方法
    public static void main(String[] args) {
        // 创建Ticket对象
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "aa").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "bb").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "cc").start();
    }
}
