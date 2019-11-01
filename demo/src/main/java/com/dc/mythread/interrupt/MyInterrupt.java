package com.dc.mythread.interrupt;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 17:14
 */
public class MyInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count =0;


                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println();
                while (!Thread.interrupted()){
                    count++;
                    System.out.println(name+":"+count);
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
        Thread.sleep(2000);

            t1.interrupt();
            t2.interrupt();



    }
}
