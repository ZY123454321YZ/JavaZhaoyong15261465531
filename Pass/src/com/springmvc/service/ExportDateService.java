package com.springmvc.service;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.Interface.ServiceInterface;
import com.springmvc.dao.ExportDataDao;
import com.springmvc.dao.OperationDataDao;
import com.springmvc.entity.OperationData;
import com.springmvc.util.CsvImExportUtil;
@Service
public class ExportDateService implements ServiceInterface
{   
	@Autowired
	private ExportDataDao dao;
	public boolean export(String filePath,List<String>dataList,List<String>nameList) throws IOException 
    {   
    	File  file = new File(filePath);
    	if(!file.exists()) 
    	{
    		file.createNewFile();
    	}
    	boolean flag = CsvImExportUtil.exportCsv(file,dataList,nameList);
    	return flag;
    }
	public List<OperationData> queryData() throws Exception
	{   
		String hql = "from OperationData";
		List<OperationData> list = dao.getOperationData(hql);
		if(list == null) 
		{
			throw new Exception("用户名或密码错误,请重新填写！"); 
		}
		return list;
	}
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	}
	
	
}
