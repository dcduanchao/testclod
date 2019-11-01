package com.dc.mythread.thread;

/**
 * @author duanchao
 * @CreateDate: 2019/10/16 0016 16:46
 */
public class MyWait {

    private volatile Boolean preIsA = false;
    public static int count =1;
    synchronized void backA() {
        try {
            while (preIsA == true) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("*****");
            }
            preIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void backB() {
        try {
            while (preIsA == false) {
                wait();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("#####");
            }
            preIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyWait myWait = new MyWait();
        for (int i = 0; i < 5; i++) {
            Thread A = new Thread(new Runnable() {
                @Override
                public void run() {
                    myWait.backA();
                }
            });
            Thread B = new Thread(() -> myWait.backB());
            A.start();
            B.start();



        }



    }


    public   int getId() throws InterruptedException {

        count=count;
        System.out.println("count:"+count);
        wait();
        count++;
        return  count;
    }

    public void notAll() {
        notifyAll();
    }
}
