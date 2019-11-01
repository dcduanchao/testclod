package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 18:19
 */
public class IntSleep {

    public static void main(String[] args)  {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("hello");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                        break;
                    }
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();

    }
}
