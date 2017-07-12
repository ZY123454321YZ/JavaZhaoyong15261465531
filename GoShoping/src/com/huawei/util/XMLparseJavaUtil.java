package com.huawei.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import com.huawei.entity.JDBCPuser;

public class XMLparseJavaUtil {
	private static Logger logger=Logger.getLogger(XMLparseJavaUtil.class);
	public static boolean parseXML(String path,Object...args){
		File f=new File(path);
//		声明JAXBContext上下文对象
		JAXBContext context;
		try {
			context=JAXBContext.newInstance(JDBCPuser.class);
//			通过上下文创建java转XML的对象Marshaller
			Marshaller m=context.createMarshaller();
			JDBCPuser puser=new JDBCPuser();
			puser.setId((int) args[0]);
		    m.marshal(puser,f);
		} catch (JAXBException e) {
			logger.error(e);
			return false;
		}
		return true;
	}
       public static boolean parseJava(){
		return false;
    	   
       }
}
