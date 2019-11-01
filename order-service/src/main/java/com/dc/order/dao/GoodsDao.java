package com.dc.order.dao;

import com.dc.order.entity.GoodsInfo;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 14:31
 */
public interface GoodsDao {
    GoodsInfo findById(Integer id);
}
