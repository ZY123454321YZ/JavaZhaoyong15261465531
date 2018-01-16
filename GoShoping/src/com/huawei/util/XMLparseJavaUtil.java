package com.huawei.util;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import com.huawei.entity.JDBCPuser;
public class XMLparseJavaUtil {
	private static Logger logger = Logger.getLogger(XMLparseJavaUtil.class);
	public static boolean parseXML(String path, Object... args) {
		File f = new File(path);
		// ����JAXBContext�����Ķ���
		JAXBContext context;
		try 
		{
			context = JAXBContext.newInstance(JDBCPuser.class);
			// ͨ�������Ĵ���javaתXML�Ķ���Marshaller
			Marshaller m = context.createMarshaller();
			JDBCPuser puser = new JDBCPuser();
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