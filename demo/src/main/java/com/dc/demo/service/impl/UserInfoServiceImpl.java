package com.dc.demo.service.impl;


import com.dc.demo.dao.UserInfoDao;
import com.dc.demo.entity.A;
import com.dc.demo.entity.B;
import com.dc.demo.entity.UserInfo;
import com.dc.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:12
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public int save(UserInfo userInfo) {
        return userInfoDao.save(userInfo);

    }

    @Override
    public UserInfo findById(Integer id) {
        logger.info("***************************id={}",id);
        return userInfoDao.findById(id);
    }

    @Override
    public int deleteById(Integer id) {
        logger.info("***************************id={}",id);
        return userInfoDao.deleteById(id);
    }

    @Override
    public UserInfo findBynameAndPwd(String name, String pwd) {
        return userInfoDao.findBynameAndPwd(name,pwd);
    }



    @Override
    public void  saveThread(){
        System.out.println("*****************开始****************");

        ExecutorService executorService= newFixedThreadPool(10);
        executorService.execute(new Runnable() {

//            new Thread(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    for (int i = 0; i < 101; i++) {
                        UserInfo info = new UserInfo();
                        String name = Thread.currentThread().getName();
                        info.setUserName(name);
                        info.setPassword("" + i);
                        info.setPhone("" + i);
                        info.setAge(i / 10000);
                        userInfoDao.save(info);
                    }
                    long end = System.currentTimeMillis();
                    long l = (end - start);
                    System.out.println("插入10万线程消耗时间=" + l);
                }
            });


        System.out.println("*****************结束****************");


    }

    @Override
    public void error() {
        try {
            Integer a = 1/0;
            System.out.println(a);
        }catch (Exception e){
            System.out.println(e.getMessage());
//            new BussException(e);
            throw e;
            
            
        }

    }

    @Override
    public B error1() {
        A a = new A();
        a.setCA("a");

        return a;
    }
}
