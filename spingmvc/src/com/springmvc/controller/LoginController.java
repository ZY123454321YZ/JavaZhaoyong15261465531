package com.springmvc.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.servlet.YZMServlet;
@Controller
@RequestMapping("/controller")
public class LoginController 
{   
	
	@Autowired  
	private HttpSession session;  
	  
	@Autowired  
	private HttpServletRequest request;
	@Autowired  
	private HttpServletResponse response;
	@RequestMapping("/login")
	public String login() 
	{  
		return "login";
	}
	
	@RequestMapping("/UserHomeList")
	@ResponseBody
	public void addUpdateUserHomeList(HttpServletRequest request, String userId) throws ServletException, IOException
	{
		YZMServlet servlet = new YZMServlet();
		servlet.service(request, response);
	}
	
	

}
