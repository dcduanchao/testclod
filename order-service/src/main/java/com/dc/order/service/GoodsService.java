package com.dc.order.service;

import com.dc.order.entity.GoodsInfo;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 14:34
 */
public interface GoodsService {
    GoodsInfo findById(Integer id);
}
