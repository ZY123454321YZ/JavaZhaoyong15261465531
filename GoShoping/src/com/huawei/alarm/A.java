package com.huawei.alarm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class A {
	public static void main(String[] args) throws IOException {
		File f = new File("E:\\nihao.sql");
		f.createNewFile();
		Writer writer = new BufferedWriter(new FileWriter(f));
		writer.write("select * from table" +"\r\n"+" order by");
		writer.flush();
		writer.close();
		}

	}
	
