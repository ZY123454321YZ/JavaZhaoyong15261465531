package com.huawei.util;
import java.util.List;

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
	// 最大连接数
	private static int MAX_ACTIVE = 1024;

	private static JedisPool POOL = null;

	private static Jedis redis = null;

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
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
	 * @return 截取字符串
	 */
	public String getSubString(String key, int startOffset, int endOffset) 
	{
		return redis.getrange(key, startOffset, endOffset);
	}
	/**
	 * 
	 * @param key
	 * @return 用于设置指定 key 的值，并返回 key 的旧值
	 */
	public String getOldValue(String key, String value)
	{
		return redis.getSet(key, value);
	}
	public static void main(String[] args) {
//		for(int i =0;i<=1023;i++) {
//			RedisUtil util = new RedisUtil();
//		}
		RedisUtil util = new RedisUtil();
		util.setKey("key", "123");
		System.out.println(util.getkey("key"));
	}
}