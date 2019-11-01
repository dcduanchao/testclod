package com.dc.demo.aop;

import com.dc.demo.entity.UserInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author duanchao
 * @CreateDate: 2019/9/25 0025 18:34
 */
@Component
@Aspect
public class ErrorAop {

    @Pointcut(value = "execution(* com.dc.demo.service.*.*(..))")
    public  void pointCut(){
    }

//    @AfterThrowing(value = "pointCut()",throwing = "ex")
//    public void doBefore(Exception ex){
//
//        System.out.println("进入 Aop...."+ex);
//
//    }

    @Before(value = "pointCut()")
    public void doBefore(){

        System.out.println("进入 Aop....");

    }

    //wwithin 切入类
    @Pointcut(value = "within( com.dc.demo.service..*)")
    public  void pointCutEX(){
    }

    @Before(value = "pointCutEX()")
    public  void after(JoinPoint joinPoint){
        System.out.println("进入 after....");
    }

}
