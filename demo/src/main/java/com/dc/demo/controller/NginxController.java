package com.dc.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanchao
 * @CreateDate: 2019/10/12 0012 16:04
 */
@RestController
@RequestMapping("ng")
public class NginxController {

    @Value("${server.port}")
    String serverPort;

    @GetMapping("get/port")
    public String getPort(){
        return  "访问"+serverPort;
    }


}
