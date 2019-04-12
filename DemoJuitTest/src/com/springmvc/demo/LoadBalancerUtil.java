package com.springmvc.demo;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class LoadBalancerUtil {
	private static ExecutorService service = Executors.newCachedThreadPool();
	public static Map<String,Integer> ipMap = new HashMap<String,Integer>();
	static 
	{
		ipMap.put("192.168.43.1", 1);
		ipMap.put("192.168.43.2", 1);
		ipMap.put("192.168.43.3", 1);
		ipMap.put("192.168.43.4", 1);
		ipMap.put("192.168.43.5", 1);
		ipMap.put("192.168.43.6", 1);
		
	}
	
	public static void main(String[] args) throws Exception 
	{
//		Future<String>result = service.submit(new Callable<String>() {
//
//			@Override
//			public String call() throws Exception 
//			{
//				Random dom = new Random();
////				return 	dom.getServerIp();
////				return dom.getServerIpHash();
//				return dom.getServerSuiji();
//			}
//		});
//        System.out.println(result.get());	
		service.execute(new Runnable() {
			@Override
			public void run() 
			{
				Random dom = new Random();
				System.out.println(dom.getServerSuiji());
			}
		});
	}
}
