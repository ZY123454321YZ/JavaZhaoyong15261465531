package com.huawei.service;
import java.util.List;
import com.huawei.entity.OperationData;
import com.huawei.util.HibernateUtil;

public class OperationDataService extends SuperService
{   
	@Override
	public List<OperationData> getValues()
	{
		HibernateUtil util = new HibernateUtil();
		String sql = "from OperationData";
		List<OperationData> list = util.query(sql,null);
        return list;		
	}

}
