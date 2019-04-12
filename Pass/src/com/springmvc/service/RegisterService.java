package com.springmvc.service;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.springmvc.entity.User;
import com.springmvc.util.HibernateUtil;
public class RegisterService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		String userName = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String sex = request.getParameter("sex");
        String year = request.getParameter("sel1");
        String month = request.getParameter("sel2");
        if(month.length() < 2) 
        {
        	month = "0" + month;
        }
        String date = request.getParameter("sel3");
        if(date.length() < 2) 
        {
        	date = "0" + date;
        }
        String date1 = year+month+date;
//		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf8");
		HibernateUtil util = new HibernateUtil();
		User user = new User();
		user.setName(userName);
		user.setSex(sex);
		user.setPassword(password);
		user.setDate(date1);
		util.add(user);

	}
	      
	        

}
