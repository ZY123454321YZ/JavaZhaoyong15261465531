package com.huawei.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.entity.User;
import com.huawei.service.QueryUserService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryUser
 */
@WebServlet("/QueryUser")
public class QueryUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Writer out = response.getWriter();
		QueryUserService service = new QueryUserService();
		List<User>list = service.getUser();
		System.out.println(list.size());
		//list Èû½ø jsonÖÐ·µ»Øjsp
		 JSONArray jsonArray = JSONArray.fromObject(list);
		 out.write(jsonArray.toString());
		 out.flush();  
	     out.close();
	}

}
