package com.huawei.alarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class CeShi {
	public static void main(String[] args) throws Exception {
		File f = new File("D:\\ceshi.properties");
		if(!f.exists())
		{
			f.createNewFile();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)
				));
		StringBuffer buffer = new StringBuffer();
		String read = "";
		while((read =reader.readLine()) != null)
		{
			System.out.println(read);
			buffer.append(read);
		}
		read = buffer.toString();
		String message = read;
		System.out.println(message);
		message.replace("人民","中国");
		System.out.println(message);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
				(new FileOutputStream(f, false)));
		writer.write(message+"\r\n 中国");
		writer.flush();
	}
	
	public static void writeFile(File f,String message) throws Exception
	{
		OutputStream outputStream = new FileOutputStream(f.getAbsolutePath(),true);
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		writer.write(message);
		writer.flush();
	}
}
