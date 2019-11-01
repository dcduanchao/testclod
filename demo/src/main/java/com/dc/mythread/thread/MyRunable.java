package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 11:20
 */
public class MyRunable  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
