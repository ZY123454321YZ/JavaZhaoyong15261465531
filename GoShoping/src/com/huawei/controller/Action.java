package com.huawei.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] pathParams = request.getServletPath().split("/");
		PrintWriter printWriter = response.getWriter();
		String[] path = pathParams[1].split("\\.");
		String p = path[0];
		if (!pathParams[1].contains(".do")) 
		{
			printWriter.write("ÇëÇóÂ·¾¶´íÎó");
			return;
		}
		if (p.equals("login")) 
		{
			request.getRequestDispatcher("/Login.do").forward(request, response);
		} 
		else if (p.equals("Register"))
		{
			request.getRequestDispatcher("/Register.do").forward(request, response);
		} 
		else if (p.equals(" CouponCode")) 
		{
			request.getRequestDispatcher("/CouponCode.do").forward(request, response);
		}else if(p.equals("CheckTest"))
		{
			request.getRequestDispatcher("/CheckTest.do").forward(request, response);
		}
	}
}
