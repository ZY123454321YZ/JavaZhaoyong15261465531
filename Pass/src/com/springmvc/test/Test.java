package com.springmvc.test;
import java.util.List;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
public class Test {
	@org.junit.Test
	@Ignore
	public void test() 
	{
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserDao userDao = (UserDao) ac.getBean("UserDao");
//		List<User>list = userDao.getUsers("from User");
//		System.out.println(list.get(0).getName());
	}
//	public static void main(String[] args) {
////		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
////		System.out.println(ac.getBean("template"));
////		UserDao userDao = (UserDao) ac.getBean("UserDao");
////		List<User>list = userDao.getUsers("from User");
////		System.out.println(list.get(0).getName());
////		List<User>list = userDao.getOneUser("from User", args)
////		userDao.deleteUser(list.get(2));
////		OperationDataDao dataDao = (OperationDataDao) ac.getBean("OperationDataDao");
////		List<OperationData>list = dataDao.getOperationData("from OperationData");
////		System.out.println(list.get(0).getCountUser());
////		CouponCodeDao dao = (CouponCodeDao) ac.getBean("CouponCodeDao");
////		List<CouponCode>code = (List<CouponCode>) dao.getCouponCode("from CouponCode");
////		System.out.println(code.get(0).getCodeNumber());
////		User user = new User();
////		user.setName("李四光");
////		user.setPassword("112233");
////		userDao.saveUser(user);
////		System.out.println(userDao.getUsers("from User").get(0).getName());
//	}

}
