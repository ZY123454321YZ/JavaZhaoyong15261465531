package com.huawei.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.entity.CouponCode;
import com.huawei.entity.User;
import com.huawei.util.HibernateUtil;

public class CouponCodeService 
{
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		String userName = new String
		(request.getParameter("couponcode").getBytes("iso-8859-1"), "UTF-8");
		HibernateUtil util = new HibernateUtil();
		CouponCode code = new CouponCode();
//		util.queryOne(sql, param);
	}
	

}
