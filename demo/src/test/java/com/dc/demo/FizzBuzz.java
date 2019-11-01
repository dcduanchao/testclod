package com.dc.demo;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author duanchao
 * @CreateDate: 2019/10/14 0014 18:48
 */
public class FizzBuzz {
    private int n;
    Semaphore sa = new Semaphore(0);
    Semaphore sb = new Semaphore(0);
    Semaphore sc = new Semaphore(0);
    Semaphore sd = new Semaphore(0);
    private int cur = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            sa.acquire();
            if (cur > n)
                break;
            printFizz.run();
            sd.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            sb.acquire();
            if (cur > n)
                break;
            printBuzz.run();
            sd.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            sc.acquire();
            if (cur > n)
                break;
            printFizzBuzz.run();
            sd.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            if (cur % 3 != 0 && cur % 5 != 0){
                printNumber.accept(cur);
            } else if (cur % 3 == 0 && cur % 5 != 0){
                sa.release();
                sd.acquire();
            } else if (cur % 5 == 0 && cur % 3 != 0){
                sb.release();
                sd.acquire();
            } else {
                sc.release();
                sd.acquire();
            }
            cur++;
            if (cur > n) {
                sa.release();
                sb.release();
                sc.release();
                break;
            }
        }
    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(()->{
            try {
                fizzBuzz.fizz(()->{
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fizzBuzz.buzz(()->{
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fizzBuzz.fizzbuzz(()->{
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{

            try {
                fizzBuzz.number(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
