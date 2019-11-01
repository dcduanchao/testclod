package com.dc.order.controller;

import com.dc.order.entity.GoodsInfo;
import com.dc.order.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 14:27
 */
@RestController
@RequestMapping("/goods")
@RefreshScope
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Value("${foo}")
    private String foo;

    @GetMapping("/find/id")
    public GoodsInfo findById(@RequestParam("id") Integer id){

        return goodsService.findById(id);

    }

    @GetMapping("/getfoo")
    public String getFoo(){
        return  "foo="+foo;
    }
}
