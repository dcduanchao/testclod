package com.dc.order.mapper;

import com.dc.order.entity.GoodsInfo;
import com.dc.order.entity.GoodsInfoWhere;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoMapper {
    long countByWhere(GoodsInfoWhere example);

    int deleteByWhere(GoodsInfoWhere example);

    int deleteById(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    List<GoodsInfo> selectByWhere(GoodsInfoWhere example);

    GoodsInfo selectById(Integer id);

    int updateByWhereSelective(@Param("record") GoodsInfo record, @Param("example") GoodsInfoWhere example);

    int updateByWhere(@Param("record") GoodsInfo record, @Param("example") GoodsInfoWhere example);

    int updateByIdSelective(GoodsInfo record);

    int updateById(GoodsInfo record);
}