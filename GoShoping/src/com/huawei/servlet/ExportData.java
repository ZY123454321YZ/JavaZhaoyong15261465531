package com.huawei.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
            String filePath = request.getParameter("file");
            if("".equals(filePath)|| filePath == null) 
            {
            	request.getSession().setAttribute("error","导出路径不存在或错误！");
    			response.sendRedirect("jsp/error.jsp");
            }
            OperationDataService dataService = new OperationDataService();
    		List<com.huawei.entity.OperationData> dataList = dataService.getData();
    		List<String> arrayList = new ArrayList<String>();
    		List<String> nameList = new LinkedList<String>();
    		for(int index = 0;index < dataList.size();index++) 
    		{
    			OperationData data = dataList.get(index);
    			arrayList.add(data.getDate());
    			arrayList.add(data.getCountUser());
    			arrayList.add(data.getCountDate());
    			arrayList.add(data.getStartDate());
    			arrayList.add(data.getEndDate());
    		}
    		String append = "日期";
    		StringBuffer buffer = new StringBuffer(append);
    		buffer.append(":在线人数").append(":在线时长").
    		append(":登陆时间").append(":注销时间");
    		String[]message = buffer.toString().split(":");
    		nameList = Arrays.asList(message);
            boolean flag = service.export(filePath, arrayList,nameList);
		
	}

}
