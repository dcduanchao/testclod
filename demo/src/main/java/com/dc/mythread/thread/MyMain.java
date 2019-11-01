package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 11:22
 */
public class MyMain {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread thread = new Thread(myThread,"线程1");
        thread.start();
        Thread thread2 = new Thread(myThread,"线程2");
        thread2.start();

        MyRunable myRunable = new MyRunable();
        Thread thread3 = new Thread(myRunable,"线程3");
        thread3.start();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("快捷创建线程"+Thread.currentThread().getName());
            }
        };
        Thread thread4 =new Thread(runnable,"线程4");
        thread4.start();
        //更加简洁
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("快捷创建线程"+Thread.currentThread().getName());
            }
        },"线程6").start();


        Runnable runnable1 =()-> System.out.println("java8创建"+Thread.currentThread().getName());
        Thread thread5 =new Thread(runnable1,"线程5");
        thread5.start();

    }
}
