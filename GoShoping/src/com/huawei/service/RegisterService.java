package com.huawei.service;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.huawei.entity.User;
import com.huawei.util.HibernateUtil;
public class RegisterService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		String userName = new String(request.getParameter("userid").getBytes("iso-8859-1"), "UTF-8");
		String password = request.getParameter("pwd");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf8");
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("YYYY");
		HibernateUtil util = new HibernateUtil();
		User user = new User();
		user.setName(userName);
		user.setSex(sex);
		user.setPassword(password);
		util.add(user);

	}

}
