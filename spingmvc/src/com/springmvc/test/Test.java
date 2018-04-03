package com.springmvc.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) ac.getBean("UserDao");
		User user = new User();
		user.setName("李四光");
		user.setPassword("112233");
		userDao.saveUser(user);
//		System.out.println(userDao.getUsers("from User").get(0).getName());
	}

}
