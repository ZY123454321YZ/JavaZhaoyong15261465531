package com.springmvc.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springmvc.Interface.ServiceInterface;
import com.springmvc.dao.OperationDataDao;
import com.springmvc.entity.OperationData;
@Service
public class OperationDataService implements ServiceInterface
{   
	@Autowired
	private OperationDataDao dao;
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

}
