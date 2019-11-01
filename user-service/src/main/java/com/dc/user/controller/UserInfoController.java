package com.dc.user.controller;

import com.dc.user.entity.UserInfo;
import com.dc.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:13
 */
@RestController
@RequestMapping("user")
public class UserInfoController {

    Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 消费者调用时对象必须加 @RequestBody
     */
    @PostMapping("/save")
    public String saveUser(@RequestBody UserInfo userInfo) {
        System.out.println("**************");
        System.out.println(userInfo);
        System.out.println("----------------------");
        int save = userInfoService.save(userInfo);
        if (save > 0) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }


    @GetMapping("/find/id")
    public UserInfo findById(Integer id) {
        return userInfoService.findById(id);

    }


    @PostMapping("/delete")
    public String deleted(Integer id) {
        int flag = userInfoService.deleteById(id);
        if (flag > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @GetMapping("/hi")
    public String  hi() {
        return "ha ha  ha";

    }


}
