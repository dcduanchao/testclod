package com.dc.demo.controller;


import com.dc.demo.entity.DataInfo;
import com.dc.demo.entity.UserInfo;
import com.dc.demo.service.UserInfoService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author duanchao
 * @CreateDate: 2019/9/11 0011 15:13
 */
@Api("描述")
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
    public void  hi() {
        userInfoService.saveThread();

    }


    @PostMapping("data")

    public  String data(  Integer type , @RequestBody DataInfo dataInfo) {

        System.out.println(type);
        UserInfo userInfo = dataInfo.getUserInfo();
        System.out.println(dataInfo);
        return "1";


    }

    @PostMapping("request/post")
    public  String requestPost(HttpServletRequest request){

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");

        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(sb.toString());

        String queryString = request.getQueryString();
        System.out.println(queryString);

        return sb.toString();
    }


}
