//package com.dc.gateway.controller;
//
//import com.dc.gateway.service.user.UserClient;
//import com.dc.user.entity.UserInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author duanchao
// * @CreateDate: 2019/9/11 0011 18:50
// */
//@RestController
////@RequestMapping("/user")
//public class UserGatewayController {
//
//
//    @Autowired
//    private UserClient userClient;
//
////    @GetMapping("/find/id")
////    public UserInfo findById(Integer id){
////        return userClient.findById(id);
////
////    }
//
//    @PostMapping("/save")
//    public String save( UserInfo userInfo){
//        System.out.println("**************");
//        System.out.println(userInfo);
//        return userClient.save(userInfo);
//
//    }
//
//    @PostMapping("/delete")
//    public String deleted(Integer id){
//       return  userClient.deleteById(id);
//    }
//}
