package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DosDemo2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStream in=null;
		Runtime runtime=Runtime.getRuntime();
//		runtime.exec("F:\apache-tomcat-7.0.68\bin\startup.bat");
		Process process=runtime.exec("F:/apache-tomcat-7.0.69/bin/startup.bat");
		in=process.getInputStream();
		BufferedReader reader=
				new BufferedReader(new InputStreamReader(in));
		String line=null;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		int exitValue=process.waitFor();
		System.out.println("·µ»ØÖµ:"+exitValue);
//		in.close();
	}

}
