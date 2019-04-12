package com.springmvc.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.entity.CouponCode;

@Repository("CouponCodeDao")
public class CouponCodeDao {

	@Autowired
	HibernateTemplate template;

	@Transactional
	public void saveCouponCode(CouponCode code) {
		template.save(code);
	}

	@Transactional
	public List<CouponCode> getCouponCode(String hql) {
		List<CouponCode> list = (List<CouponCode>) template.find(hql);
		return list;
	}

	@Transactional
	public boolean deleteCouponCode(CouponCode code) {
		try {
			template.delete(code);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
