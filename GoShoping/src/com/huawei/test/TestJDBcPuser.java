package com.huawei.test;
import org.junit.Test;
import com.huawei.entity.User;
import com.huawei.util.JDBCUti;
import com.huawei.util.MysqlJDBCUtilone;
import com.huawei.util.MysqlJDBCUtiltwo;
public class TestJDBcPuser {
	@Test
	public void test() 
	{
		String sql = "insert into puser(name,password) values(?,?)";
		String[] args = new String[] { "name", "password" };
		for (int i = 0; i < 50; i++) 
		{
			if (i % 2 == 1) 
			{
				JDBCUti<User> util = new MysqlJDBCUtilone();
				util.insert(sql, args);
			} 
			else
			{
				JDBCUti<User> util2 = new MysqlJDBCUtiltwo();
				util2.insert(sql, args);
			}
		}
	}
}