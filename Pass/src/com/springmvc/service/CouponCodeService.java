package com.springmvc.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springmvc.entity.CouponCode;
import com.springmvc.util.HibernateUtil;
public class CouponCodeService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sql = "from CouponCode where codenumber = ?";
		HibernateUtil util = new HibernateUtil();
		CouponCode code = null;
		String[]param = new String[]{"1576"};
		Object object = util.queryOne(sql, param);
		if(object instanceof CouponCode) 
		{
			
			code = (CouponCode) object;
		}
		if(!request.getParameter("couponcode").equals(code.getCodeNumber())) 
		{
			response.sendRedirect("/GoShoping/html/error.html");
		}
		else 
		{
			response.sendRedirect("/GoShoping/html/index.html");
		}
		
	}

}
