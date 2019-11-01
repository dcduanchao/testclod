package com.dc.user.service.impl;

import com.dc.user.dao.UserInfoDao;
import com.dc.user.entity.UserInfo;
import com.dc.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:12
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public int save(UserInfo userInfo) {
        return userInfoDao.save(userInfo);

    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoDao.findById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoDao.deleteById(id);
    }

    @Override
    public UserInfo findBynameAndPwd(String name, String pwd) {
        return userInfoDao.findBynameAndPwd(name,pwd);
    }
}
