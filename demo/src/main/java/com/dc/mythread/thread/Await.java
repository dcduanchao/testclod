package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/17 0017 17:37
 */
public class Await {

    static  volatile  int count;

    public static void main(String[] args) {
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            System.out.println(name+"waiting");
            synchronized (Await.class){
                count++;
                System.out.println(name+count);
                try {
                    Thread.sleep(2000);
                    while (count<3){
                        System.out.println(name+"jinru1");
                        Await.class.wait();
                    }
                } catch (InterruptedException e) {
                }
            }
            System.out.println(name+"end");

        };

        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        Thread t3 = new Thread(r,"t3");
        t1.start();
        t2.start();
        t3.start();
//        r = new Runnable() {
//            @Override
//            public void run() {
//
//                while (count<3){
//                    try {
//                        Thread.sleep(100);
//                        synchronized (Await.class){
//
//                            Await.class.notifyAll();
//                        }
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        };
//        Thread t4 = new Thread(r);
//        t4.start();

    }


}
