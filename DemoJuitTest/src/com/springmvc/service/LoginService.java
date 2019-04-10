package com.springmvc.service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.Interface.ServiceInterface;
import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
@Service
public class LoginService implements ServiceInterface {
	@Autowired
	private UserDao dao;
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sessMessage = ((String) session.getAttribute("VALIDATECODE")).toUpperCase();
		String yzm = request.getParameter("yzm").toUpperCase();
		if (!sessMessage.equals(yzm)) 
		{
			throw new Exception("验证码错误,请重新填写验证码！");
		}
		String userName = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String[]args = new String[] {password};
		String hql = "from User  where password = ? " ;
		List<User> user =  dao.getOneUser(hql,args);
		System.out.println(user.get(0).getName());
		if (user == null) 
		{
			throw new Exception("用户名或密码错误,请重新填写！");
		}
		return;
	}
}
