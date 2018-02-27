package com.huawei.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.util.HibernateUtil;

public class LoginService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		String userName = new String(request.getParameter("userid").getBytes("iso-8859-1"), "UTF-8");
		String password = request.getParameter("pwd");
		HibernateUtil util = new HibernateUtil();
		String[] message = new String[] {userName,password};
		String sql = "from User where name = ? and password = ? ";
		Object object = util.queryOne(sql, message);
		request.getSession().setAttribute("key",object);
         
	}

}
