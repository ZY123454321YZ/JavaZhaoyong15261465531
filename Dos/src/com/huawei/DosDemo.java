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
		;//����
//		
		Process process=
				Runtime.getRuntime().exec(cmd);
//		��ȡִ��cmd��������Ϣ
		in=process.getInputStream();
		BufferedReader reader=
				new BufferedReader(new InputStreamReader(in));
		String line=null;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);	
		}
		int exitValue=process.waitFor();
		System.out.println("����ֵ:"+exitValue);
//		in.close();
	}
 
}
