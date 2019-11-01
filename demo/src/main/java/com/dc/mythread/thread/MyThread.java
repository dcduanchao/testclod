package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 11:19
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
