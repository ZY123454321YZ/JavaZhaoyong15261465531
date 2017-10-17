package com.huawei.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @author zhaoyong 
 * Date   2017/10/17
 */
public class RedisUtil {
	private static String ip = "127.0.0.1";
	
	private static int port = 6379;
	
	private static int timeOut = 1000;
	
	private static int MAX_ACTIVE = 1024;

	private static JedisPool pool = null;
	
	private static Jedis redis = null;
	
	private final Object o = new Object();
	static
	{   
		try 
		{  
			if(pool == null) 
			{
				pool = new JedisPool();
			}
			
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public Jedis getRedis() 
	{   
		synchronized (o) 
		{
			if(redis == null)
			{
				redis = pool.getResource();
			}
			return redis;
		}
	}
	public void setKey(String key,String value)
	{
		redis.set(key, value);
	}
    
	/**
	 * 
	 * @param sting key
	 * @return string 
	 */
	public String getkey(String key)
	{
		return redis.get(key);
	}
	/**
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return  截取字符串
	 */
	public String getSubString(String key,int startOffset,int endOffset)
	{   
		return redis.getrange(key, startOffset, endOffset);
	}
	
	/**
	 * 
	 * @param key
	 * @return  用于设置指定 key 的值，并返回 key 的旧值
	 */
	public String getOldValue(String key,String value)
	{
		return redis.getSet(key, value);
	}
	
    public static void main(String[] args) {
		RedisUtil util = new RedisUtil();
		Jedis dis = util.getRedis();
		dis.set("key","demo");
		System.out.println(dis.get("key"));
		
		
	}
}
