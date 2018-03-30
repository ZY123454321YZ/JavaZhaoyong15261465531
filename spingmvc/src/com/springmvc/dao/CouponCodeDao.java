package com.springmvc.dao;
import java.util.List;
import com.springmvc.entity.CouponCode;

public interface CouponCodeDao {
	public List<CouponCode> getCouponCode(String...strings);
	public CouponCode queryCouponCode();
}
