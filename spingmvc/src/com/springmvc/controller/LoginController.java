package com.springmvc.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springmvc.service.LoginService;

@Controller
@RequestMapping("/controller")
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@RequestMapping("/login")
	public String login() throws IOException {
		try {
			service.doService(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("error", e.getMessage());
			return "error";
		}
		return "login";
	}

	/**
	 * 
	 * @return regst.jsp
	 */
	@RequestMapping(value = "/regst")
	public String test() {
		return "regst";
	}

	/**
	 * 处理注册信息
	 * 
	 * @return Register service/dao
	 */
	@RequestMapping(value = "/Register")
	public String register() {

		return "Register";
	}

}
