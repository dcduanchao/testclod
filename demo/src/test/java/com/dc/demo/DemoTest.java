package com.dc.demo;

import com.dc.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.SimpleFormatter;

/**
 * @author duanchao
 * @CreateDate: 2019/10/11 0011 14:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    private static  Object r1 = new Object();
    private static  Object r2 = new Object();

    @Test
    public void  t1(){
//        User user1 = new User("aa",1);
//        User user2 = new User("aa",1);
////        System.out.println(user1==user2);
////        System.out.println(user1.equals(user2));
////        te(user1);
////        System.out.println(user1);
//        Integer a = 1;
//        System.out.println(a==user1.getAge());

//        float a = 1.0f - 0.9f;
//        float b = 0.9f - 0.8f;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a == b);



        Integer[] a = {1,2,3,4};
        List<Integer> list = Arrays.asList(a);
        list.add(5);
        System.out.println(list);
//        BigDecimal

    }
    private void te(User user1) {
        user1.setAge(55);
    }



    @Test
    public void  t2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            synchronized (r1){
                System.out.println(Thread.currentThread()+"get r1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting r2");
                synchronized (r2){
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread()+"get r2");

                }
            }

        },"线程1").start();

        new Thread(()->{
            synchronized (r1){
                System.out.println(Thread.currentThread()+"get r1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting r2");
                synchronized (r2){
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread()+"get r2");

                }
            }

        },"线程2").start();


        countDownLatch.await();
        System.out.println("结束");

    }

    static  int i =0;
    
    @Test
    public void t3() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{

            try {
                sytest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{

            try {
                sytest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        countDownLatch.await();
        ThreadLocal<SimpleDateFormat> formatterThreadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));
    }

    private  synchronized void sytest() throws InterruptedException {
        i++;
        Thread.sleep(1000);
        System.out.println("i="+i);
    }

    @Test
    public  void t4(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.toPattern();
        System.out.println(s);

        ThreadFactory threadFactory = null;
        threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
        Executors.newFixedThreadPool(1,threadFactory);
    }

    @Test
    public  void t5(){
        String a = "1";
        String b = "9";
        addStrings(a,  b);
    }

    private void addStrings(String a, String b) {
    int i =a.length()-1;
    int j = b.length()-1;
    int d=0;
    boolean f = false;
    StringBuilder sb = new StringBuilder();
    while (i>=0||j>=0){
        int ca = 0;
        int cb = 0;
        if(i>=0){
             ca = a.charAt(i)-'0';
        }
        if(j>=0){
             cb = b.charAt(j)-'0';
        }
        int sum =ca+cb+d;

        if(sum>=10){
            d=1;
            sb.append(sum%10);
            f=true;
        }else {
            d=0;
            sb.append(sum);
            f= false;
        }
        i--;
        j--;
    }
    if(f){
        sb.append("1");
    }

        System.out.println(sb.reverse().toString());
    }
}



