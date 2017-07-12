package com.Test;

import java.util.Date;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Factory.HibernateUtil;
import com.entity.Hibernatepuser;

public class PuserTest {
	public static void main(String[] args) {
		Hibernatepuser p=new Hibernatepuser();
		p.setId("66");
		p.setAge(15);
		p.setName("小李飞到");
		p.setDate(new Date());
//		开启hibernate对话
		Session session=HibernateUtil.getSession();
		System.out.println(session);
//		开启一个事务
		Transaction trans=
				session.beginTransaction();
		session.persist(p);
		trans.commit();
		session.close();
		
		
		
		
		
	}

}
