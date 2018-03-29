package com.springmvc.servlet;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springmvc.service.OperationDataService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class OperationData
 */
@WebServlet("/OperationData")
public class OperationData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OperationData() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperationDataService service = new OperationDataService();
		List<com.springmvc.entity.OperationData> list = service.getData();
		Writer out = response.getWriter();
		JSONArray array = JSONArray.fromObject(list);
		out.write(array.toString());
		out.flush();
		out.close();
	}

}
