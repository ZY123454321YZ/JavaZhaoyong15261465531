package com.springmvc.service;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.springmvc.util.CsvImExportUtil;
public class ExportDateService 
{
    public boolean export(String filePath,List<String>dataList) throws IOException 
    {   
    	File  file = new File(filePath);
    	if(!file.exists()) 
    	{
    		file.createNewFile();
    	}
    	boolean flag = CsvImExportUtil.exportCsv(file, dataList);
    	return flag;
    }
	
	
}
