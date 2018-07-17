package com.springmvc.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.entity.OperationData;
import com.springmvc.service.ExportDateService;
import com.springmvc.service.LoginService;
import com.springmvc.service.OperationDataService;

@Controller
@RequestMapping("/controller")
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private OperationDataService dataService;
	@Autowired
	private ExportDateService exportService;
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
		return "index";
	}

	/**
	 * 统计运营数据
	 * @return /Operationaldata
	 * @throws Exception 
	 */
	@RequestMapping(value = "/Operationdata")
	public ModelAndView Operationaldata() 
	{   
		ModelAndView model = new ModelAndView("/Operationadata");
		try {
			List<OperationData>list = dataService.queryData();
			model.addObject("list",list);
		} 
		catch (Exception e)
		{
			request.getSession().setAttribute("error", e.getMessage());
		}
		return model;
	}

	/**
	 * 导出运营数据
	 * 
	 * @return Register service/dao
	 * @throws Exception 
	 */
	@RequestMapping(value = "/exportData")
	public ModelAndView exportData() throws Exception 
	{   
		ModelAndView model = new ModelAndView("/exportData");
		ExportDateService service = new ExportDateService();
        String filePath = request.getParameter("file");
         if("".equals(filePath)|| filePath == null) 
         {
         	request.getSession().setAttribute("error","导出路径不存在或错误！");
 			response.sendRedirect("jsp/error.jsp");
         }
        OperationDataService dataService = new OperationDataService();
 		List<OperationData> dataList = exportService.queryData();
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
		return model;
	}

}
