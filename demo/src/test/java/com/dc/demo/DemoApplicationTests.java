package com.dc.demo;

import com.dc.demo.config.RedisClient;
import com.dc.demo.entity.B;
import com.dc.demo.entity.UserInfo;
import com.dc.demo.service.BeService;
import com.dc.demo.service.impl.BussException;
import com.dc.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void contextLoads() throws InterruptedException {
//        userInfoService.saveThread();


        ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                System.out.println("222");
                return null;
            }
        });
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 1; i++) {
            executorService.execute(() -> {
                try {

                    for (int j = 0; j < 1; j++) {
                        semaphore.acquire();
//                        UserInfo info = new UserInfo();
//                        String name = Thread.currentThread().getName();
//                        info.setUserName(name);
//                        info.setPassword("12425");
//                        info.setPhone("12");
//                        info.setAge(11);
//                        userInfoService.save(info);
                        System.out.println("4444");
                        semaphore.release();


                            countDownLatch.countDown();

                    }
                    System.out.println("结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();


    }
    @Autowired
    RedisClient redisClient;

    @Test
    public void test(){
//        UserInfo byId = userInfoService.findById(201);
//        System.out.println(byId);
        bussException.t();
//        redisClient.set(byId.getId()+"",byId);
//
//        UserInfo redisClient1 = redisClient.get1(byId.getId() + "");

//        System.out.println(redisClient1);

    }

    @Autowired
    BussException bussException;

    @Test
    public void test1(){
        B b = userInfoService.error1();
        System.out.println(b);


//        userInfoService.error();
//        bussException.t();

////        BussException exception = new BussException();
//        bussException.t();
//        System.out.println("jieshu1");
    }

}
