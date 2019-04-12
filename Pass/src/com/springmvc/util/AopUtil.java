package com.springmvc.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopUtil {
	/**
     * 开会之前--找个位置坐下
     */
    @Before("execution(* com.springmvc.service.OperationDataService.queryData(..))")
    public void takeSeats() {
        System.out.println("找位置坐");
    }
 
 
    /**
     * 开会之后--写会议总结报告
     */
    @After("execution(* com.springmvc.service.OperationDataService.queryData(..))")
    public void summary() {
        System.out.println("写会议总结报告");
    }

}
