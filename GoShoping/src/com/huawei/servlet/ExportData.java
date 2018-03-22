package com.huawei.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.entity.OperationData;
import com.huawei.service.ExportDateService;
import com.huawei.service.OperationDataService;

/**
 * Servlet implementation class ExportDate
 */
@WebServlet("/ExportData")
public class ExportData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportData() {
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
            ExportDateService service = new ExportDateService();
            String filePath = request.getParameter("key1");
            if("".equals(filePath)|| filePath == null) 
            {
            	request.getSession().setAttribute("error","导出路径不存在或错误！");
    			response.sendRedirect("jsp/error.jsp");
            }
            OperationDataService dataService = new OperationDataService();
    		List<com.huawei.entity.OperationData> dataList = dataService.getData();
    		List<String> arrayList = new ArrayList<String>();
    		for(int index = 0;index < dataList.size();index++) 
    		{
    			OperationData data = dataList.get(index);
    			arrayList.add(data.getCountDate());
    			arrayList.add(data.getCountUser());
    			arrayList.add(data.getDate());
    			arrayList.add(data.getEndDate());
    			arrayList.add(data.getStartDate());
    		}
            boolean flag = service.export(filePath, arrayList);
		
	}

}
