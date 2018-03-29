package com.springmvc.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.springmvc.util.HibernateUtil;
public class LoginService {
	public void doService(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String sessMessage = (String) session.getAttribute("VALIDATECODE");
		String yzm = request.getParameter("yzm");
		if (!sessMessage.equals(yzm)) {
			throw new Exception("��֤�����,��������д��֤�룡");
		}
		String userName = request.getParameter("userid");
		String password = request.getParameter("pwd");
		HibernateUtil util = new HibernateUtil();
		String[] message = new String[] { userName, password };
		String sql = "from User where name = ? and password = ? ";
		Object object = util.queryOne(sql, message);
		if (object == null) {
			throw new Exception("�û������������,��������д��");
		}
		return;
	}

}
