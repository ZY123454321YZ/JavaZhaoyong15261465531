package com.huawei.service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.entity.User;
import com.huawei.util.HibernateUtil;

public class QueryUserService extends SuperService
{
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.doService(request, response);
	}

	
	@Override
	public List<User> getValues()
	{   
		HibernateUtil util = new HibernateUtil();
		List<User> list = null;
		String sql = "from User";
		list = util.query(sql,null);
		return list;
	}

}
