package com.springmvc.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.User;
@Repository("UserDao")
public class UserDao {

	@Autowired
	HibernateTemplate template;
	@Transactional
	public void saveUser(User user) {
		template.save(user);

	}
	@Transactional
	public List<User> getUsers(String hql) {
		List<User> list = (List<User>) template.find(hql);
		return list;
	}

}
