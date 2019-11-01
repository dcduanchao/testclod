package com.dc.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author duanchao
 * @CreateDate: 2019/10/14 0014 18:29
 */
public class Foo {
    CountDownLatch downLatch1;
    CountDownLatch downLatch2;
    public Foo() {
         downLatch1 = new CountDownLatch(0);
         downLatch2 = new CountDownLatch(0);
    }



    public void  frist(Runnable runnable){
        runnable.run();
        downLatch1.countDown();

    }
    public void  two(Runnable runnable) throws InterruptedException {
        downLatch1.await();
        runnable.run();
        downLatch2.countDown();

    }
    public void  three(Runnable runnable) throws InterruptedException {
        downLatch2.await();
        runnable.run();

    }

    public static void main(String[] args) {

        Foo foo = new Foo();
        Thread thread1 = new Thread(()->{
            try {
                foo.frist(()->{
                    System.out.println("1");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                foo.two(()->{
                    System.out.println("2");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try {
                foo.three(()->{
                    System.out.println("3");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
