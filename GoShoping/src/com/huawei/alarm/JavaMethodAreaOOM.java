package com.huawei.alarm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {
	public static void main(String[] args) throws IOException {
//		while (true) {
//		Enhancer enhancer = new Enhancer();
//		enhancer.setSuperclass(OOMObject.class);
//		enhancer.setUseCache(false);
//		enhancer.setCallback(new MethodInterceptor() {
//		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws
//		Throwable {
//		return proxy.invokeSuper(obj, args);
//		}
//		});
//		enhancer.create();
//		}
//		}
//		static class OOMObject {
		File f = new File("E:\\nihao.sql");
		f.createNewFile();
		Writer writer = new BufferedWriter(new FileWriter(f));
		writer.write("select * from table" );
		writer.flush();
		writer.close();
		}
		}
