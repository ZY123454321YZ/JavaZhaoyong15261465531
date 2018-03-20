package com.huawei.service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.huawei.util.HibernateUtil;

public class LoginService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        HttpSession session = request.getSession();
        String sessMessage = (String) session.getAttribute("VALIDATECODE");
        String yzm = request.getParameter("yzm");
        if(!sessMessage.equals(yzm)) 
        {
        	throw new Exception("验证码错误,请重新填写验证码！");
        }
		String userName = request.getParameter("userid");
        String password = request.getParameter("pwd");
		HibernateUtil util = new HibernateUtil();
		String[] message = new String[] {userName,password};
		String sql = "from User where name = ? and password = ? ";
		Object object = util.queryOne(sql, message);
         return;
	}

}
