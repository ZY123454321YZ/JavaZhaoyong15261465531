package com.huawei.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CouponCode
 */
@WebServlet("/CouponCode")
public class CouponCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponCode() {
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
//          CouponCodeService service = new CouponCodeService();
          try 
          {          	
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      		Date date = new Date();
        	BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuilder responseStrBuilder = new StringBuilder();
			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
			responseStrBuilder.append(inputStr);
			JSONObject jsonObject = JSONObject.fromObject(responseStrBuilder.toString());
        	Iterator<String> it = jsonObject.keys(); 
        	while(it.hasNext())
        	{
        	String key = it.next(); 
        	String value = jsonObject.getString(key);    
//        	System.out.println("��: "+key+",ֵ:"+value);
        	System.out.println(format.format(date) + "--------"+key+","+value );
        	}
		  } 
          catch (Exception e) 
          {   
        	  throw e;
		  }
	}

}
