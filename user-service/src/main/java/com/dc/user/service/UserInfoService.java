package com.dc.user.service;

import com.dc.user.entity.UserInfo;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:12
 */
public interface UserInfoService {
    int save(UserInfo userInfo);

    UserInfo findById(Integer id);

    int deleteById(Integer id);

    UserInfo findBynameAndPwd(String name,String pwd);
}
