package com.springmvc.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.OperationData;

@Repository("ExportDataDao")
public class ExportDataDao 
{
	@Autowired
	HibernateTemplate template;

	@Transactional
	public void saveOperationData(OperationData data) {
		template.save(data);
	}

	@Transactional
	public List<OperationData> getOperationData(String hql) {
		List<OperationData> list = (List<OperationData>) template.find(hql);
		return list;
	}

	@Transactional
	public boolean deleteOperationData(OperationData data) {
		try {
			template.delete(data);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	
	
}
