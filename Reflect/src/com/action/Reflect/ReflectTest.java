package com.action.Reflect;

import java.lang.reflect.*;

import javax.activation.FileDataSource;

public class ReflectTest {
	private String fname;
	private String lname;
	public ReflectTest(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	public static void main(String[] args) {
		try {
			ReflectTest f=new ReflectTest("java","aspect");
			run(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void run(Object o) throws Exception {
            	Field[]	fields=o.getClass().getDeclaredFields();
		        System.out.println("替换之前的:");
		        for(Field file:fields){
		        	System.out.println(file.getName()+"="+file.get(o));
		        	if(file.getType().equals(java.lang.String.class)){
		        		file.setAccessible(true);
		        		String obj=
		        				(String) file.get(o);
                       file.set(o,obj.replace("a","b"));
		        	}
		        }
		System.out.println("替换之后的:");
		for(Field file:fields){
        	System.out.println(file.getName()+"="+file.get(o));
        }
		
	}
	
	

}
