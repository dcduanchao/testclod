//package com.dc.gateway.service.user;
//
//import com.dc.gateway.config.FeignConfig;
//import com.dc.user.entity.UserInfo;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author duanchao
// * @CreateDate: 2019/9/11 0011 18:53
// */
//@Component
//@FeignClient(name = "user-service",configuration = FeignConfig.class, fallback = UserClientBackService.class)
//public interface UserClient {
//
///**需要加@RequestParam不然会被转发报错405*/
//    @GetMapping("/user/find/id")
//    UserInfo findById(@RequestParam("id") Integer id);
//
//    @PostMapping("/user/save")
//    String save(UserInfo userInfo);
//
//    @PostMapping("/user/delete")
//    String deleteById(@RequestParam("id")  Integer id);
//}
