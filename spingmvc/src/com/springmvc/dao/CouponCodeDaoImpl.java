package com.springmvc.dao;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.springmvc.entity.CouponCode;
import com.springmvc.util.HibernateUtil;
@Repository("CouponCodeDao")
public class CouponCodeDaoImpl implements CouponCodeDao{
	@Resource
	private static SessionFactory sessionFactory;
	@Override
	public List<CouponCode> getCouponCode() {
		String sql = "from CouponCode where codenumber = ?";
		HibernateUtil util = new HibernateUtil();
		CouponCode code = null;
		String[]param = new String[]{"1576"};
		Object object = util.queryOne(sql, param);
		if(object instanceof CouponCode) 
		{
			
			code = (CouponCode) object;
		}
		return null;
	}
	@Override
	public CouponCode queryCouponCode() {
		return null;
	}
	
}
