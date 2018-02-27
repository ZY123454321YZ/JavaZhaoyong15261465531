package com.huawei.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.service.LoginService;
import com.huawei.service.RegisterService;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String[]pathParams = request.getServletPath().split("/");
               if(!pathParams[1].contains(".do"))
               {
            	   response.getWriter().write("����·������");
               }
               String[] path = pathParams[1].split("\\.");
               String p = path[0];
               if(p.equals("login"))
               {
            	   try {
   					new LoginService().doService(request, response);
   				} catch (Exception e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
   				if(request.getSession().getAttribute("key")!=null)
   				{
   					response.getWriter().write("��½�ɹ�....��תҳ��");
   					request.getRequestDispatcher("/home.html").forward(request, response);
   					
   				}
//   				response.getWriter().write("�û���������� !");
//   				try 
//   				{
//   					new Thread().sleep(2000);
//   				} 
//   				catch (InterruptedException e1) 
//   				{
//   				}
//   				request.getRequestDispatcher("/index.html").forward(request, response);  
//               }
//               else if (p.equals("Register"))
//               {
//            	   try 
//           		{  
//           			new RegisterService().doService(request, response);
//           			response.getWriter().write("��½�ɹ�....��תҳ��");
//           			new Thread().sleep(2000);
////           			�ض���ҵ����ҳ
//           			response.sendRedirect("html/home.html");
//           		} 
//           		catch (Exception e)
//           		{   
//           			System.out.println(e);
//           			response.getWriter().write("is error !");
//           			
//           		}
               }
	          }
             }
