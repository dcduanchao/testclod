package com.dc.user.mapper;

import com.dc.user.entity.UserInfo;
import com.dc.user.entity.UserInfoWhere;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInfoMapper {
    long countByWhere(UserInfoWhere example);

    int deleteByWhere(UserInfoWhere example);

    int deleteById(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByWhere(UserInfoWhere example);

    UserInfo selectById(Integer id);

    int updateByWhereSelective(@Param("record") UserInfo record, @Param("example") UserInfoWhere example);

    int updateByWhere(@Param("record") UserInfo record, @Param("example") UserInfoWhere example);

    int updateByIdSelective(UserInfo record);

    int updateById(UserInfo record);
}