//package com.dc.gateway.service.goods;
//
///**
// * @author duanchao
// * @CreateDate: 2019/9/12 0012 14:42
// */
//
//import com.dc.gateway.config.FeignConfig;
//import com.dc.order.entity.GoodsInfo;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Component
//@FeignClient(name = "order-service",configuration = FeignConfig.class)
//public interface GoodsClient {
//
//
//    @RequestMapping(value = "/goods/find/id",method = RequestMethod.GET)
//     GoodsInfo findById(@RequestParam("id")Integer id);
//
//
//}
