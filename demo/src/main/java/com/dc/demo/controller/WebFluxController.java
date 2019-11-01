package com.dc.demo.controller;

import com.dc.demo.entity.UserInfo;
import com.dc.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author duanchao
 * @CreateDate: 2019/9/20 0020 16:48
 */
@RestController
@RequestMapping("")
public class WebFluxController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/webflux/id")
    public Mono<UserInfo> findById(Integer id){
        UserInfo byId = userInfoService.findById(id);
        Mono<UserInfo> just = Mono.just(byId);
        return  just;
    }
}
