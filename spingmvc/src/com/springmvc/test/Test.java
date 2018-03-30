package com.springmvc.test;

import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springmvc.dao.CouponCodeDao;

import scala.languageFeature.implicitConversions;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		CouponCodeDao userDao=(CouponCodeDao) ac.getBean("CouponCodeDao");
//        System.out.println(userDao);
//        System.out.println(userDao.getCouponCode("1576").get(0).getCodeNumber());
	}

}
