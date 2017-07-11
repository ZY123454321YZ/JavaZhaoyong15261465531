package com.xy.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.entity.puser;
import com.xy.dao.MybatisUserDao;
import com.xy.util.MybatisUtil;

public class Test1 {
	@Test
	public void test1() throws Exception{
		 
			   SqlSession se=MybatisUtil.getSession();
			    System.out.println(se);
	   try{
//		   puser pp=new puser();
		   Map map=new  HashMap();
		   for(int i=0;i<20;i++){
			   map.put("name","zhaosi"+i);
			   map.put("age","26");
			   se.insert("emp.insertuser",map);
			   se.commit();
		   }
		   
	} catch (Exception e) {
		e.printStackTrace();
		se.rollback();
	}


	}
	
//	@Test
//	public void test2(){
//		SqlSession se=MybatisUtil.getSession();
//		try {
//         puser p=new MybatisUserDao().getPuser(95);
//         p.setName("zhaoyong");
//         p.setAge("25");
//         se.update("emp.update",p);
//         se.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			se.rollback();
//		}finally {
//			se.close();
//		}
//		
//	}

}
