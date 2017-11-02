package com.xy.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MybatisUtil {
	private static SqlSessionFactory sf;
	//����builder
	static{
		
			SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
			//���������ļ�������session����
			sf = builder.build(
				MybatisUtil.class.getClassLoader()
					.getResourceAsStream("SqlMapConfig.xml"));
	}

	
	public static SqlSession getSession(){
		return  sf.openSession();
	}
}
