package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import com.huawei.entity.User;
import com.huawei.util.HibernateUtil;

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
