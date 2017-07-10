package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DosDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStream in=null;
		String cmd=
				"cmd.exe /c start"
//				Runtime.getRuntime().exec("cmd.exe /c start "
		;//命令
//		
		Process process=
				Runtime.getRuntime().exec(cmd);
//		获取执行cmd命令后的信息
		in=process.getInputStream();
		BufferedReader reader=
				new BufferedReader(new InputStreamReader(in));
		String line=null;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);	
		}
		int exitValue=process.waitFor();
		System.out.println("返回值:"+exitValue);
//		in.close();
	}
 
}
