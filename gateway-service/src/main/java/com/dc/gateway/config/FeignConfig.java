//package com.dc.gateway.config;
//
//import feign.Retryer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author duanchao
// * @CreateDate: 2019/9/12 0012 10:29
// * feign 失败重试 默认100毫秒 最大1s 5次
// */
//@Configuration
//public class FeignConfig {
//
//    @Bean
//    public Retryer retryer(){
//        return  new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 5);
//    }
//}
