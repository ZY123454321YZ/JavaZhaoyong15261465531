package com.springmvc.util;
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
	 * @return ��ȡ�Ự����
	 */
	public static SessionFactory getSessionFactory() 
	{
		// ��һ��:��ȡHibernate�������ļ� hibernamte.cfg.xml�ļ�
		// Configuration con=
		// new Configuration().configure();
		Configuration conf = new Configuration();
		// ����������
		conf.configure();
		// new AnnotationConfiguration().configure();
		// //�ڶ���:��������ע�ṹ��������ͨ�����ö����м������е�������Ϣ
		// ServiceRegistryBuilder regbulider=new
		// ServiceRegistryBuilder().applySettings(con.getProperties());
		// //����ע�����
		// ServiceRegistry reg=regbulider.buildServiceRegistry();
		// ������:�����Ự����
		// SessionFactory sessionFactory=con.buildSessionFactory(reg);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		return sessionFactory;
	}
	/**
	 * @return ��ȡ�Ự����
	 */
	public static Session getSession() 
	{
		return getSessionFactory().openSession();
	}
	/**
	 * @param obj
	 *            �������
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
	 * @return �������� ����Ϊ�޸ĵ�����id����
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
				// ����ع�
				tran.rollback();
			}
		} 
		finally
		{
			if (session != null)
			{
				// �ر�session
				session.close();
			}
		}
		return result;
	}
	/**
	 * @param c
	 * @param obj
	 *            ��ѯһ�����ݸ���������id��
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
				// �ر�session
				session.close();
			}
		}
		return object;
	}
	/**
	 * @param obj
	 * @return ɾ������
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
				// ����ع�
				tran.rollback();
			}
		} 
		finally 
		{
			if (session != null)
			{
				// �ر�session
				session.close();
			}
		}
		return result;
	}
	/**
	 * @param <T>
	 *            ��ѯ������¼
	 * @param sql
	 *            sql���
	 * @param param
	 *            ��������
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
	 *            ��ѯ������¼
	 * @return
	 */
	public static Object queryOne(String sql,String[]param)
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
					query.setString(i, param[i]);
				}
				object = query.uniqueResult();
			}
		} 
		catch (Exception e)
		{
			throw e;
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
	 * @return ʵ�ַ�ҳ��ѯ
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
			// ɸѡ����
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
	 * @return�������ݸ���
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