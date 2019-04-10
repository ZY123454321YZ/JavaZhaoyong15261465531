package com.springmvc.util;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @author zhaoyong Date 2017/10/17
 */
public class RedisUtil {
	private static String HOST = "127.0.0.1";

	private static int PORT = 6379;

	private static int TIMEOUT = 1000;
	// ���������
	private static int MAX_ACTIVE = 1024;

	private static JedisPool POOL = null;

	private static Jedis redis = null;

	// ����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��
	private static int MAX_IDLE = 200;

	// �ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
	private static int MAX_WAIT = 10000;

	// ��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
	private static boolean TEST_ON_BORROW = true;

	private final Object o = new Object();
	static {
		try 
		{
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWait(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			POOL = new JedisPool(config, HOST, PORT);
			redis = getRedis();
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static synchronized Jedis getRedis() 
	{
		if (redis == null)
		{
			redis = POOL.getResource();
		}
		return redis;
	}
	public void setKey(String key, String value) 
	{
		redis.set(key, value);
	}
	/**
	 * 
	 * @param sting
	 *            key
	 * @return string
	 */
	public String getkey(String key) 
	{
		return redis.get(key);
	}
	public Object[] MGet(String... keys)
	{
		Object[] objs = new Object[keys.length];
		for (int index = 0; index < keys.length; index++) 
		{
			objs[index] = getkey(keys[index]);
		}
		return objs;
	}
	/**
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return ��ȡ�ַ���
	 */
	public String getSubString(String key, int startOffset, int endOffset) 
	{
		return redis.getrange(key, startOffset, endOffset);
	}
	/**
	 * 
	 * @param key
	 * @return ��������ָ�� key ��ֵ�������� key �ľ�ֵ
	 */
	public String getOldValue(String key, String value)
	{
		return redis.getSet(key, value);
	}
}