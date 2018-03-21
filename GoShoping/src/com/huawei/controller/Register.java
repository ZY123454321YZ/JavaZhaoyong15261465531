package com.huawei.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.service.RegisterService;
import com.huawei.util.HibernateUtil;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try 
      		{  
      			new RegisterService().doService(request, response);
      			new Thread().sleep(1000);
//      			重定向到业务首页
      			response.sendRedirect("jsp/login.jsp");
      		} 
      		catch (Exception e)
      		{   
      			request.getSession().setAttribute("error","注册信息错误，请重新填写！");
    			response.sendRedirect("jsp/error.jsp");
      		}
	}

}
