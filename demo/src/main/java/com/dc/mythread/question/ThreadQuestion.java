package com.dc.mythread.question;

import com.dc.mythread.thread.MyWait;

/**
 * @author duanchao
 * @CreateDate: 2019/10/17 0017 13:56
 */
public class ThreadQuestion {
    public static int a =10;

    public static void main(String[] args)   {
//        checkThenAct();
        
//        readModifyWrite();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    a=a+100;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//        }
        System.out.println(a);


    }
    //竞态条件 readModifyWrite 新状态继承旧状态
    private static void readModifyWrite() {

        MyWait myWait = new MyWait();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+myWait.getId());
                } catch (InterruptedException e) {
                }
            }
        };


        new Thread(r,"线程1").start();
        new Thread(r,"线程2").start();
        myWait.notAll();


    }






    //竞态条件 check-then-ack  检查动作结果不同
    private static void checkThenAct() {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                a=20;
            }
        };

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("结果"+result());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r).start();


    }

    private  static  Integer result() throws InterruptedException {

        if(a==10){
            Thread.sleep(1000);
            return  a/2;
        }
        return 0;
    }
}
