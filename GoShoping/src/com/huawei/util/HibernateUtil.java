package com.huawei.util;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	/**
	 * @return 获取会话工厂
	 */
	public static SessionFactory getSessionFactory() 
	{
		// 第一步:读取Hibernate的配置文件 hibernamte.cfg.xml文件
		// Configuration con=
		// new Configuration().configure();
		Configuration conf = new Configuration();
		// 加载主配置
		conf.configure();
		// new AnnotationConfiguration().configure();
		// //第二步:创建服务注册构建器对象，通过配置对象中加载所有的配置信息
		// ServiceRegistryBuilder regbulider=new
		// ServiceRegistryBuilder().applySettings(con.getProperties());
		// //创建注册服务
		// ServiceRegistry reg=regbulider.buildServiceRegistry();
		// 第三步:创建会话工厂
		// SessionFactory sessionFactory=con.buildSessionFactory(reg);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		return sessionFactory;
	}
	/**
	 * @return 获取会话对象
	 */
	public static Session getSession() 
	{
		return getSessionFactory().openSession();
	}
	/**
	 * @param obj
	 *            添加数据
	 * @return
	 */
	public static boolean add(Object obj)
	{
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		session = getSession();
		tran = session.beginTransaction();
		session.save(obj);
		tran.commit();
		result = true;
		return result;
	}
	/**
	 * @return 更新数据 参数为修改的主键id对象
	 */
	public static boolean update(Object object)
	{
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try 
		{
			session = getSession();
			tran = session.beginTransaction();
			session.update(object);
			tran.commit();
			result = true;
		} 
		catch (Exception e) 
		{
			if (tran != null)
			{
				// 事物回滚
				tran.rollback();
			}
		} 
		finally
		{
			if (session != null)
			{
				// 关闭session
				session.close();
			}
		}
		return result;
	}
	/**
	 * @param c
	 * @param obj
	 *            查询一条数据根据主键的id号
	 * @return
	 */
	public static Object get(Class c, int obj) 
	{
		Session session = null;
		Object object = null;
		try 
		{
			session = getSession();
			object = session.get(c, obj);
		} 
		catch (Exception e) 
		{
			throw e;
		}
		finally 
		{
			if (session != null) 
			{
				// 关闭session
				session.close();
			}
		}
		return object;
	}
	/**
	 * @param obj
	 * @return 删除数据
	 */
	public static boolean delete(Object obj)
	{
		Session session = null;
		Transaction tran = null;
		boolean result = false;
		try
		{
			session = getSession();
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
			result = true;
		}
		catch (Exception e)
		{
			if (tran != null)
			{
				// 事物回滚
				tran.rollback();
			}
		} 
		finally 
		{
			if (session != null)
			{
				// 关闭session
				session.close();
			}
		}
		return result;
	}
	/**
	 * @param <T>
	 *            查询多条记录
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> query(String sql, String[] param)
	{
		List<T> list = new ArrayList<T>();
		Session session = null;
		try 
		{
			session = getSession();
			Query query = session.createQuery(sql);
			if (param != null)
			{
				for (int i = 0; i < param.length; i++) 
				{
					query.setString(i, param[i]);
				}
			}
			list = query.list();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		return list;
	}
	/**
	 * @param sql
	 * @param param
	 *            查询单条记录
	 * @return
	 */
	public static Object queryOne(String sql, String[] param)
	{
		Object object = null;
		Session session = null;
		try 
		{
			session = getSession();
			Query query = session.createQuery(sql);
			if (param != null)
			{
				for (int i = 0; i < param.length; i++) 
				{
					query.setString(0, param[i]);
				}
				object = query.uniqueResult();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (session != null)
			{
				session.close();
			}
		}
		return object;
	}
	/**
	 * @param <T>
	 * @param sql
	 * @param param
	 * @param page
	 * @param size
	 * @return 实现分页查询
	 */
	@SuppressWarnings("unchecked")
	public static List queryByPage(String sql, int page, int size) 
	{
		List list = new ArrayList();
		Session session = null;
		try 
		{
			session = getSession();
			Query query = session.createQuery(sql);
			// if(param!=null)
			// {
			// for(int i=0;i<param.length;i++)
			// {
			// query.setString(i,param[i]);
			// }
			// }
			// 筛选条数
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			list = query.list();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (session != null) 
			{
				session.close();
			}
		}
		return list;
	}

	/**
	 * @param hql
	 * @param pras
	 * @return返回数据个数
	 */
	public static int getCount(String hql) 
	{
		int resu = 0;
		Session s = null;
		try
		{
			s = getSession();
			Query q = s.createQuery(hql);
			resu = Integer.valueOf(q.iterate().next().toString());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (s != null)
				s.close();
		}
		return resu;
	}
	public static void main(String[] args) throws NoSuchAlgorithmException 
	{
		String hql = "select * from Hibernatepuser";
		int count = getCount(hql);
		List list = queryByPage(hql, 3, 10);
		System.out.println(list.size());
		// System.out.println(count);
		// while(true){
		// Hibernatepuser pHibernatepuser=new Hibernatepuser();
		// pHibernatepuser.setAge(10);
		// pHibernatepuser.setName("zy");
		// pHibernatepuser.setSex("M");
		// add(pHibernatepuser);
		// }
		//
		// pHibernatepuser.setDate(new Date());

		// String password="123456";
		// MessageDigest md = MessageDigest.getInstance("MD5");
		// md.update(password.getBytes());
		// byte b[] = md.digest();
		//
		// int i;
		//
		// StringBuffer buf = new StringBuffer("");
		// for (int offset = 0; offset < b.length; offset++) {
		// i = b[offset];
		// if (i < 0)
		// i += 256;
		// if (i < 16)
		// buf.append("0");
		// buf.append(Integer.toHexString(i));
		// }
		// pHibernatepuser.setPassword(buf.toString());
		// String hql="select * from Hibernatepuser";
		// List list=queryByPage(hql,3,10);
		// System.out.println(list.size());
	}
}