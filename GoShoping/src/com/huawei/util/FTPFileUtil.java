package com.huawei.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPFileUtil {
	private static FTPClient client = new FTPClient();
	private static FileInputStream inputStream = null;
	private static FileOutputStream outputStream = null;
	/**
	 * FTP 上传
	 * @param f
	 * @param path
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean fileUpLoad(File f,String username,String password)
	{   
		try {
			client.connect("192.168.101.130");
			client.login(username, password);
			if(!FTPReply.isPositiveCompletion(client.getReplyCode()))
			{
				System.out.println("FTP 连接失败");
			}
			else 
			{
				System.out.println("FTP 连接成功 " + "连接成功回复码：" + client.getReplyCode());
			}
			inputStream = new FileInputStream(f);
		
			// 设置上传目录  
			client.changeWorkingDirectory("/home/root123/");
			client.makeDirectory("zhaoyong");
			client.changeWorkingDirectory("/home/root123/zhaoyong");
			client.setBufferSize(1024 * 1024 * 1024);
			client.setControlEncoding("GBK");
			// 设置文件类型（二进制）
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			client.storeFile("test.sql",inputStream);
			inputStream.close();
			client.logout();
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean fileDownLoad(File f,String hostname,String username,String password,String pathname)
	{   
		try {
			client.connect(hostname);
			client.login(username, password);
			
			if(!FTPReply.isPositiveCompletion(client.getReplyCode()))
			{   
				client.disconnect();
				System.out.println("FTP 连接失败");
			}
			else 
			{
				System.out.println("FTP 连接成功");
			}
			//设置下载目录
			client.changeWorkingDirectory(pathname);
			client.setBufferSize(1024 * 24);
			client.setControlEncoding("GBK");
			
			//设置文件类型（二进制）
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			outputStream = new FileOutputStream(f);
			client.retrieveFile("test.sql",outputStream);
			outputStream.close();
		} catch (SocketException e)
		{
			return false;
		} catch (IOException e)
		{
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		File f = new File("E:\\distribution-karaf-0.3.0-Lithium.zip");
		fileUpLoad(f,"root123","123456");
	}
	
}
