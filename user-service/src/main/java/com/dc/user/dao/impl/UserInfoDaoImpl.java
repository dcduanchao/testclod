package com.dc.user.dao.impl;

import com.dc.user.dao.UserInfoDao;
import com.dc.user.entity.UserInfo;
import com.dc.user.entity.UserInfoWhere;
import com.dc.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:10
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int save(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        Assert.notNull(id, "查询用户id 不能为空");
        return userInfoMapper.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return userInfoMapper.deleteById(id);
    }

    @Override
    public UserInfo findBynameAndPwd(String name, String pwd) {
        UserInfoWhere where = new UserInfoWhere();
        UserInfoWhere.Criteria c = where.createCriteria();
        c.andUserNameEqualTo(name).andPasswordEqualTo(pwd);
        List<UserInfo> userInfos = userInfoMapper.selectByWhere(where);

        return userInfos.get(0);
    }
}
