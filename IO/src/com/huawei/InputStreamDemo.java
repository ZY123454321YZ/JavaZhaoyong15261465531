package com.huawei;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class InputStreamDemo {
	public static void main(String[] args) throws IOException 
	{
		File f=new File("D:a.txt");
	    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter writer=
				new BufferedWriter(new FileWriter(f,false));
	    StringBuffer buffer;
	    String message;
	    while ((message=reader.readLine())!=null) 
	    {
	    	PrintWriter out=new PrintWriter(writer);
	    	out.println(message);
			if(message.equals("q"))
			{
				break;
			}
		}
		writer.close();
	}
}
