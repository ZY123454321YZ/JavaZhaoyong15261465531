package com.huawei.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huawei.util.CsvImExportUtil;

public class ExportDateService extends SuperService
{   
	
	
    @Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super.doService(request, response);
	}

	public boolean export(String filePath,List<String>dataList,List<String>nameList) throws IOException 
    {   
    	File  file = new File(filePath);
    	if(!file.exists()) 
    	{
    		file.createNewFile();
    	}
    	boolean flag = CsvImExportUtil.exportCsv(file, dataList,nameList);
    	return flag;
    }

	@Override
	public <T> List<T> getValues() {
		return null;
	}
	
	
}
