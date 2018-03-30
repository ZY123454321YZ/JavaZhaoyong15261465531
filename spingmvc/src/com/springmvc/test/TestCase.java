package com.springmvc.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.CouponCodeDao;
import com.springmvc.dao.CouponCodeDaoImpl;

public class TestCase {
	@Autowired
	private CouponCodeDaoImpl impl;
	@Test
	public void test() {
		impl.getCouponCode("1576");
	}

}
