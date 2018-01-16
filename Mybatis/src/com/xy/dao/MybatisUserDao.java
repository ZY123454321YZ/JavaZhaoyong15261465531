package com.xy.dao;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import com.entity.puser;
import com.xy.util.MybatisUtil;
public class MybatisUserDao {
	SqlSession session=MybatisUtil.getSession();
	public puser getPuser(int id){
			puser p=session.selectOne("emp.findById",id);
			System.out.println("∏˘æ›ID≤È’“:"+p.getName());
			session.close();
		    return p;
	}
	public void update(puser p)
	{
		try 
		{
			session.update("emp.update",p);
			session.commit();
		} 
		catch (Exception e) 
		{
			session.rollback();
		}
		finally 
		{
			session.close();
		}
	}
	public static void main(String[] args) 
	{
		MybatisUserDao dao = 
				new MybatisUserDao();
			puser e = dao.getPuser(1);
			System.out.println(e.getAge());
//			Map map=new HashMap();
//			map.put("id",98);
//			map.put("name","÷Ì∞ÀΩ‰");
//			map.put("age",e.getAge());
//			dao.update(e);
	}
}
