package com.dc.order.dao;

import com.dc.order.entity.GoodsInfo;
import com.dc.order.mapper.GoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 14:32
 */
@Repository
public class GoodsDaoImpl implements  GoodsDao {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;
    @Override
    public GoodsInfo findById(Integer id) {
        return goodsInfoMapper.selectById(id);
    }
}
