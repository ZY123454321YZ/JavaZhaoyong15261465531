package com.springmvc.demo;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Random
{  
		private static String ip1 = "127.0.0.1";
		private static String ip2 = "127.0.0.2";
		private static String ip3 = "127.0.0.3";
		private static String ip4 = "127.0.0.4";
		private static String ip5 = "127.0.0.5";
		private static String ip6 = "127.0.0.6";
		private static 	Integer i = 0;
		static Lock lock = new ReentrantLock();
	
	//随机调度
	public static String getServerIp() 
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.putAll(LoadBalancerUtil.ipMap);
		Set<String>set = map.keySet();
		List<String>arrayList = new ArrayList<String>();
		arrayList.addAll(set);
		java.util.Random random = new java.util.Random();
		int randomPos = random.nextInt(arrayList.size());
		System.out.println(randomPos);
		return arrayList.get(randomPos);
	}
	
	
	
	//源地址hash
	public static String getServerIpHash() 
	{
		Map<String,Integer>map = new HashMap<String,Integer>();
		map.putAll(LoadBalancerUtil.ipMap);
		Set<String>set = map.keySet();
		List<String>arrayList = new ArrayList<String>();
		arrayList.addAll(set);
		int hashCode = ip6.hashCode();
		System.out.println("hashCode:_ " +hashCode );
		int arrayLength = arrayList.size();
		int num = hashCode % arrayLength;
		System.out.println("num:" + num);
		return arrayList.get(num);
	}
	
	//轮询调度算法
	public static String getServerSuiji() 
	{   
		Map<String,Integer>map = new HashMap<String,Integer>();
		map.putAll(LoadBalancerUtil.ipMap);
		Set<String>set = map.keySet();
		List<String>list = new ArrayList<String>();
		list.addAll(set);
		String server = null;
		synchronized (i)
		{
//		lock.lock();
			if(i > list.size())
			{
				i = 0;
			}
			server = list.get(i);
			i++;
//		lock.unlock();
		}
		return server;
		
	}
	
	
//	加权随机
	public static String getServerJiaQuan() 
	{
		Map<String,Integer>map = new HashMap<String,Integer>();
		return "";
		
	}
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				Random dom = new Random();
				System.out.println(dom.getServerSuiji());
			}
			}
		);
         Thread tt = new Thread(new Runnable() {
			@Override
			public void run() {
				Random dom = new Random();
				System.out.println(dom.getServerSuiji());
			}
			}
		);
         Thread ttt = new Thread(new Runnable() {
 			@Override
 			public void run() {
 				Random dom = new Random();
 				System.out.println(dom.getServerSuiji());
 			}
 			}
 		);
         
         Thread tttt = new Thread(new Runnable() {
 			@Override
 			public void run() {
 				Random dom = new Random();
 				System.out.println(dom.getServerSuiji());
 			}
 			}
 		);
         t.start();
         tt.start();
         ttt.start();
         tttt.start();
	}
}
