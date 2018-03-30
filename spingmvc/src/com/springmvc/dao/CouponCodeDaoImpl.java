package com.springmvc.dao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.springmvc.entity.CouponCode;
import com.springmvc.util.HibernateUtil;
@Repository("CouponCodeDao")
public class CouponCodeDaoImpl implements CouponCodeDao{
	// 1.将sessionFactory注入到template
    // template 注入到 UserDao
    // spring 提供一个对象(CRUD操作)

    @Autowired
    HibernateTemplate template;
	@Override
	public List<CouponCode> getCouponCode(String...param) {
		String sql = "from CouponCode where codenumber = ?";
		HibernateUtil util = new HibernateUtil();
		List<CouponCode>list = new ArrayList<CouponCode>();
		list = util.query(sql, param);
		return list;
	}
	@Override
	public CouponCode queryCouponCode() {
		return null;
	}
	
}
