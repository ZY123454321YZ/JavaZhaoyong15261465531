package com.springmvc.service;
import java.util.List;
import com.springmvc.entity.User;
import com.springmvc.util.HibernateUtil;
public class QueryUserService 
{
	public List<User> getUser()
	{   
		HibernateUtil util = new HibernateUtil();
		List<User> list = null;
		String sql = "from User";
		list = util.query(sql,null);
		return list;
	}

}
