package com.dc.order.service;

import com.dc.order.dao.GoodsDao;
import com.dc.order.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 14:34
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public GoodsInfo findById(Integer id) {
        return goodsDao.findById(id);
    }
}
