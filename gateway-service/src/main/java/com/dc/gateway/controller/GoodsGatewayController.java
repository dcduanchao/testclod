//package com.dc.gateway.controller;
//
//import com.dc.gateway.service.goods.GoodsClient;
//import com.dc.order.entity.GoodsInfo;
//import com.dc.user.entity.UserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author duanchao
// * @CreateDate: 2019/9/12 0012 15:18
// */
//@RestController
////@RequestMapping("/goods")
//public class GoodsGatewayController {
//
//    @Autowired
//    GoodsClient goodsClient;
//
//    @RequestMapping("find/id")
//    public GoodsInfo findById(Integer id){
//        return goodsClient.findById(id);
//    }
//}
