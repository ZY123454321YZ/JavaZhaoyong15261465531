package com.huawei.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

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
//        	System.out.println("¼ü: "+key+",Öµ:"+value);
        	System.out.println(""+key+","+value);
        	}
		  } 
          catch (Exception e) 
          {   
        	  throw e;
		  }
	}

}
