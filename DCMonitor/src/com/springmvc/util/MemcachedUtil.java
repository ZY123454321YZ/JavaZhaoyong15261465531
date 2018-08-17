package com.springmvc.util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
public class MemcachedUtil {
	private static MemCachedClient memCachedClient;
	static {
		/************************************
		 * ����Memcached
		 **************************************/
		SockIOPool sockIOPool = SockIOPool.getInstance();
		sockIOPool.setServers(new String[] { "127.0.0.1:11211" });// ����memcached��������ַ
		sockIOPool.setWeights(new Integer[] { 3 }); // ����ÿ��MemCached������Ȩ��
		sockIOPool.setFailover(true); // ��һ��memcached������ʧЧ��ʱ���Ƿ�ȥ������һ��memcached������.
		sockIOPool.setInitConn(10); // ��ʼ��ʱ��ÿ��������������������Ŀ
		sockIOPool.setMinConn(10); // ÿ��������������С��������
		sockIOPool.setMaxConn(100); // ÿ����������������������
		sockIOPool.setMaintSleep(30); // �Բ��߳����ڽ��й�������ÿ������ʱ��
		sockIOPool.setNagle(false); // Socket�Ĳ����������true��д����ʱ�����壬�������ͳ�ȥ��Tcp�Ĺ������ڷ���һ����֮ǰ�����ķ��ͷ���ȴ�Զ�̽��շ�ȷ�����յ���һ�η��͹����İ�����������Ϳ��Թر��׽��ֵĻ��桪����׼������������
		sockIOPool.setSocketTO(3000); // Socket������ȡ���ݵĳ�ʱʱ��
		sockIOPool.setAliveCheck(true); // �����Ƿ���memcached�������Ƿ�ʧЧ
		sockIOPool.setMaxIdle(1000 * 30 * 30); // ���������ʱ��
		sockIOPool.setSocketConnectTO(0); // ���ӽ���ʱ�Գ�ʱ�Ŀ���
		sockIOPool.initialize(); // ��ʼ�����ӳ�
		if (memCachedClient == null) 
		{
			memCachedClient = new MemCachedClient();
			memCachedClient.setPrimitiveAsString(true); // �Ƿ񽫻�������ת��ΪString����
		}
	}
	private MemcachedUtil()
	{
	}
	/**
	 * �򻺴���Ӽ�ֵ�ԡ�ע�⣺������Ѿ����ڣ���֮ǰ�ļ���Ӧ��ֵ�����滻��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean set(String key, Object value)
	{
		try 
		{
			return memCachedClient.set(key, value);
		} 
		catch (Exception e) 
		{
			MemcachedLogUtils.writeLog("Memcached set��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * �򻺴���Ӽ�ֵ�Բ�Ϊ�ü�ֵ���趨����ʱ�䣨���೤ʱ���ü�ֵ�Դ�Memcached�ڴ滺����ɾ�������磺 new
	 * Date(1000*10)�����ʾʮ��֮���Memcached�ڴ滺����ɾ������ע�⣺������Ѿ����ڣ���֮ǰ�ļ���Ӧ��ֵ�����滻��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean set(String key, Object value, Date expire)
	{
		try
		{
			return memCachedClient.set(key, value, expire);
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached set��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * �򻺴���Ӽ�ֵ�ԡ�ע�⣺���������в����ڼ�ʱ���Ż���ӳɹ���
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean add(String key, Object value)
	{
		try 
		{
			if (get(key) != null) 
			{
				MemcachedLogUtils.writeLog("Memcached add��������keyֵ��" + key + "\r\n"
						+ exceptionWrite(new Exception("Memcached�ڴ滺�����Ѿ����ڸü�ֵ��")));
				return false;
			} 
			else
			{
				return memCachedClient.add(key, value);
			}
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached add��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * �򻺴���Ӽ�ֵ�Բ�Ϊ�ü�ֵ���趨����ʱ�䣨���೤ʱ���ü�ֵ�Դ�Memcached�ڴ滺����ɾ�������磺 new
	 * Date(1000*10)�����ʾʮ��֮���Memcached�ڴ滺����ɾ������ע�⣺���������в����ڼ�ʱ���Ż���ӳɹ���
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean add(String key, Object value, Date expire)
	{
		try 
		{
			if (get(key) != null) 
			{
				MemcachedLogUtils.writeLog("Memcached add��������keyֵ��" + key + "\r\n"
						+ exceptionWrite(new Exception("Memcached�ڴ滺�����Ѿ����ڸü�ֵ��")));
				return false;
			} 
			else 
			{
				return memCachedClient.add(key, value, expire);
			}
		} 
		catch (Exception e) 
		{
			MemcachedLogUtils.writeLog("Memcached add��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * ���ݼ����滻Memcached�ڴ滺�������еĶ�Ӧ��ֵ��ע�⣺ֻ�иü�����ʱ���Ż��滻����Ӧ��ֵ��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean replace(String key, Object newValue)
	{
		try 
		{
			return memCachedClient.replace(key, newValue);
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached replace��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * ���ݼ����滻Memcached�ڴ滺�������еĶ�Ӧ��ֵ����������ʱ�䣨���೤ʱ���ü�ֵ�Դ�Memcached�ڴ滺����ɾ�������磺 new
	 * Date(1000*10)�����ʾʮ��֮���Memcached�ڴ滺����ɾ������ע�⣺ֻ�иü�����ʱ���Ż��滻����Ӧ��ֵ��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean replace(String key, Object newValue, Date expireDate) 
	{
		try 
		{
			return memCachedClient.replace(key, newValue, expireDate);
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached replace��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * ���ݼ���ȡMemcached�ڴ滺�����ϵͳ����Ӧ��ֵ
	 * 
	 * @author GaoHuanjie
	 */
	public static Object get(String key)
	{
		try
		{
			return memCachedClient.get(key);
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached get��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return null;
		}
	}
	/**
	 * ���ݼ�ɾ��memcached�еļ�/ֵ��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean delete(String key)
	{
		try 
		{
			return memCachedClient.delete(key);
		} 
		catch (Exception e)
		{
			MemcachedLogUtils.writeLog("Memcached delete��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * ���ݼ�������ʱ�䣨���磺new Date(1000*10)��ʮ�����ڣ�ɾ�� memcached�еļ�/ֵ��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean delete(String key, Date expireDate)
	{
		try 
		{
			return memCachedClient.delete(key, expireDate);
		} 
		catch (Exception e) 
		{
			MemcachedLogUtils.writeLog("Memcached delete��������keyֵ��" + key + "\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * �������е����м�/ֵ��
	 * 
	 * @author GaoHuanjie
	 */
	public static boolean flashAll()
	{
		try 
		{
			return memCachedClient.flushAll();
		} 
		catch (Exception e) 
		{
			MemcachedLogUtils.writeLog("Memcached flashAll��������\r\n" + exceptionWrite(e));
			return false;
		}
	}
	/**
	 * ����String���͵��쳣ջ��Ϣ
	 * 
	 * @author GaoHuanjie
	 */
	private static String exceptionWrite(Exception exception)
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		exception.printStackTrace(printWriter);
		printWriter.flush();
		return stringWriter.toString();
	}
	/**
	 * Memcached��־��¼����
	 * 
	 * @author GaoHuanjie
	 */
	private static class MemcachedLogUtils 
	{
		private static FileWriter fileWriter;
		private static BufferedWriter logWrite;
		private final static String PID = ManagementFactory.getRuntimeMXBean().getName();// ͨ���ҵ���Ӧ��JVM���̻�ȡPID
		/**
		 * ��ʼ��Memcached��־д����
		 * 
		 * @author GaoHuanjie
		 */
		static 
		{
			try
			{
				String osName = System.getProperty("os.name");
				if (osName.contains("Windows")) 
				{
					fileWriter = new FileWriter("D:\\memcached.log", true);
				} 
				else 
				{
					fileWriter = new FileWriter("/usr/local/logs/memcached.log", true);
				}
				logWrite = new BufferedWriter(fileWriter);
			} 
			catch (IOException iOException)
			{
				iOException.printStackTrace();
				try 
				{
					if (fileWriter != null) 
					{
						fileWriter.close();
					}
					if (logWrite != null)
					{
						logWrite.close();
					}
				} 
				catch (Exception exception)
				{
					exception.printStackTrace();
				}
			}
		}
		/**
		 * д����־��Ϣ
		 * 
		 * @author GaoHuanjie
		 */
		public static void writeLog(String logContent) 
		{
			try 
			{
				logWrite.write("[" + PID + "] " + "- [" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
						+ "]\r\n" + logContent);
				logWrite.newLine();
				logWrite.flush();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		public static void main(String[] args) 
		{
			MemcachedUtil util = new MemcachedUtil();
			util.set("key", "789");
		}
	}
}