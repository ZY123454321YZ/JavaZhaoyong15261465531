package com.springmvc.util;

import java.util.ArrayList;
import java.util.List;
import org.snmp4j.log.ConsoleLogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.log.LogFactory;
 
public class SnmpTest {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		SnmpTest test = new SnmpTest();
		
		test.testGet();
		
	}
	
	public void testGet()
	{
	String ip = "127.0.0.1";
	String community = "public";
//	String oidval = "1.3.6.1.2.1.1.6.0";
	String oidval = "1.3.6.1.2.1.7.1";
	SnmpData.snmpGet(ip, community, oidval);
	}
 
 
	public void testGetList(){
	String ip = "127.0.0.1";
     String community = "public";
     List<String> oidList=new ArrayList<String>();
     oidList.add("1.3.6.1.2.1.1.5.0");
     oidList.add("1.3.6.1.2.1.1.7.0");
      SnmpData.snmpGetList(ip, community, oidList);
	}
	
	
	public void testGetAsyList()
	{
	String ip = "127.0.0.1";
	String community = "public";
	List<String> oidList=new ArrayList<String>();
	oidList.add("1.3.6.1.2.1");
	oidList.add("1.3.6.1.2.12");
	SnmpData.snmpAsynGetList(ip, community, oidList);
	System.out.println("i am first!");
	}
 
	
	public void testWalk()
	{
	String ip = "127.0.0.1";
	String community = "public";
	String targetOid = "1.3.6.1.2.1.1.5.0";
	SnmpData.snmpWalk(ip, community, targetOid);
	}
	
 
	public void testAsyWalk()
	{
	String ip = "127.0.0.1";
	String community = "public";
	// 异步采集数据
	SnmpData.snmpAsynWalk(ip, community, "1.3.6.1.2.1.25.4.2.1.2");
	}
	
	
	public void testSetPDU() throws Exception
	{
	String ip = "127.0.0.1";
	String community = "public";
	SnmpData.setPDU(ip, community, "1.3.6.1.2.1.1.6.0","jianghuiwen");
	}
	
 
	public void testVersion()
	{
		System.out.println(org.snmp4j.version.VersionInfo.getVersion());
	}
}
