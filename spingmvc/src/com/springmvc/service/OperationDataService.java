package com.springmvc.service;
import java.util.List;
import com.springmvc.entity.OperationData;
import com.springmvc.util.HibernateUtil;

public class OperationDataService 
{
	public List<OperationData> getData()
	{
		HibernateUtil util = new HibernateUtil();
		String sql = "from OperationData";
		List<OperationData> list = util.query(sql,null);
        return list;		
	}

}
