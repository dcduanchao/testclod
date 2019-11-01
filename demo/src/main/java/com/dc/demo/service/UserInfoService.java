package com.dc.demo.service;


import com.dc.demo.entity.B;
import com.dc.demo.entity.UserInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:12
 */
@CacheConfig(cacheNames = "userInfo")
public interface UserInfoService {
    int save(UserInfo userInfo);

    @Cacheable(key = "#p0")
    UserInfo findById(Integer id);

    int deleteById(Integer id);

    UserInfo findBynameAndPwd(String name, String pwd);

    void saveThread();

    void error();

    B error1();
}
