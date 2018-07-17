package com.huawei.service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.huawei.entity.CouponCode;
import com.huawei.util.HibernateUtil;
public class CouponCodeService extends SuperService{
	@Override
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

	@Override
	public <T> List<T> getValues() {
		return null;
	}

}
