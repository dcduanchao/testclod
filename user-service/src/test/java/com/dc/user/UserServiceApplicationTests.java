package com.dc.user;
import java.util.Date;

import com.dc.user.entity.UserInfo;
import com.dc.user.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void contextLoads() {
        UserInfo dc = userInfoService.findBynameAndPwd("dc", "456");
        System.out.println(dc);
    }



    @Test
    public void  save(){
        for (int i=0;i<10;i++){
            MyThread thread = new MyThread();
            thread.start();
        }



    }


    class MyThread extends Thread{
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i=0;i<100000;i++){
                UserInfo info = new UserInfo();
                String name = Thread.currentThread().getName();
                info.setUserName(name);
                info.setPassword(""+i);
                info.setPhone(""+i);
                info.setAge(i/10000);
                userInfoService.save(info);
            }
            long end = System.currentTimeMillis();
            long l = (end - start);
            System.out.println("插入10万线程消耗时间="+l);
        }
    }



}
