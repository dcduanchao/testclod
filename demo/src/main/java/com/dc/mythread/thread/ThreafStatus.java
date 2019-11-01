package com.dc.mythread.thread;

import static com.google.common.collect.ComparisonChain.start;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 15:48
 */
public class ThreafStatus {

    private  static  final  Object r1 = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println(Thread.currentThread() + "get r1");
                while (true){

                }


            }

        }, "线程1");

        Thread t2 = new Thread(() -> {
            synchronized (r1) {
                System.out.println(Thread.currentThread() + "get r1");


            }

        }, "线程2");

        t1.start();
        t2.start();

        int i=20;
        while (i>0){
            System.out.println(t1.getState());
            System.out.println(t2.getState());
            Thread.sleep(1000);
            i--;
        }

    }
}
