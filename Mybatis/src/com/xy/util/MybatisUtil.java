package com.xy.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MybatisUtil {
	private static SqlSessionFactory sf;
	//创建builder
	static{
		
			SqlSessionFactoryBuilder builder = 
				new SqlSessionFactoryBuilder();
			//加载配置文件并创建session工厂
			sf = builder.build(
				MybatisUtil.class.getClassLoader()
					.getResourceAsStream("SqlMapConfig.xml"));
	}

	
	public static SqlSession getSession(){
		return  sf.openSession();
	}
}
