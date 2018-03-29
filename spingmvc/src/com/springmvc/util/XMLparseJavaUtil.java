package com.huawei.util;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import com.huawei.entity.User;
public class XMLparseJavaUtil {
	private static Logger logger = Logger.getLogger(XMLparseJavaUtil.class);
	public static boolean parseXML(String path, Object... args) {
		File f = new File(path);
		// 声明JAXBContext上下文对象
		JAXBContext context;
		try 
		{
			context = JAXBContext.newInstance(User.class);
			// 通过上下文创建java转XML的对象Marshaller
			Marshaller m = context.createMarshaller();
			User puser = new User();
			puser.setId((int) args[0]);
			m.marshal(puser, f);
		} 
		catch (JAXBException e) 
		{
			logger.error(e);
			return false;
		}
		return true;
	}
	public static boolean parseJava()
	{
		return false;
	}
	public static void main(String[] args) throws Exception 
	{
		Properties properties = new Properties();
		File f = new File("/WebContent/pro/jdbc1.properties");
		properties.load(new FileInputStream(f));
		System.out.println(properties.getProperty("url"));
	}
}