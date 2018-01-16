package com.huawei.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties getByName(String name) throws Exception 
	{
        String pathname = getPath(name);
		File f = new File(pathname);
		FileInputStream fileInputStream = new FileInputStream(f);
		Properties pro = new Properties();
		pro.load(fileInputStream);
		String value = (String) pro.get("key");
		new Thread(new Runnable() {
			@Override
			public void run() {
			}
		}).start();
		return pro;
	}
	public static String getPath(String pathName) 
	{
		String path = new StringBuffer("WebContent").append(File.separator).
				append("pro").append(File.separator).append(pathName).toString();
		return path;
	}
}
