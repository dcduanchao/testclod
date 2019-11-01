package com.dc.demo.dao;


import com.dc.demo.entity.UserInfo;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:09
 */
public interface UserInfoDao {

    int save(UserInfo userInfo);

    UserInfo findById(Integer id);

    int deleteById(Integer id);

    UserInfo findBynameAndPwd(String name, String pwd);
}
