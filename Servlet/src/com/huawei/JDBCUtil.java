package com.huawei;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.PreparedStatement;

public class JDBCUtil {
	private static Logger log=Logger.getLogger(JDBCUtil.class);
	Connection conn=null;
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库加载成功!");
			String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=GBK";
			String user="root";
			String password="123456";
			conn=DriverManager.getConnection(url, user, password);
			log.info("已成功与mysql数据库建立连接");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void insertPuser(String name,String age) throws SQLException{
		try {
			conn=getConnection();
			String sql="insert into puser(name,age)values(?,?)";
			PreparedStatement statement=(PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1,name);
			statement.setString(2,age);
			statement.execute();
			System.out.println(statement);
		} catch (SQLException e) {
			log.error("数据库执行异常");
//			conn.rollback();
		}finally {
			log.info("关闭数据库连接");
			System.out.println("关闭数据库连接");
//			conn.close();
		}
	}

	
	
}
