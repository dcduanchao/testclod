package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 13:37
 */
public class ThreadMethodMain {



    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        //或
        /*myThread.setName("线程");
        myThread.start();*/

//        for (int i = 0; i < 5; i++) {
//            Thread A = new Thread(() -> backA());
//            Thread B = new Thread(() -> backB());
//            A.start();
//            B.start();
//        }

    }
}
