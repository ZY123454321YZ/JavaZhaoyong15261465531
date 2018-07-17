package com.springmvc.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StingUtil {
	// listת����
	public static <T> Object[] ListParseArray(List<T> list) 
	{
		Object[] o = list.toArray();
		return o;
	}
	// String�ǿ�У��
	public static boolean isEmpty(String message) 
	{
		if (message.isEmpty() || message.equals("")) 
		{
			return false;
		}
		return true;
	}
	// Object�ǿ�У��
	public static boolean isObjectEmpty(Object o)
	{
		if (o == null) 
		{
			return true;
		}
		return false;
	}
	// ����תlist
	public static boolean arraytoList(Object[] obj)
	{
		if (obj.length <= 0) 
		{
			return false;
		}
		try
		{
			List<Object> list = Arrays.asList(obj);
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	// ����HashMap
	public static Object[] getHashMapValue(Map map)
	{
		Object[] objects = new Object[map.size()];
		Set set = map.keySet();
		int i = 0;
		Iterator it = set.iterator();
		while (it.hasNext()) 
		{
			objects[i] = map.get(it.next());
			i++;
		}
		return objects;
	}
	// ����hashmap keyֵ����
	public static Object[] getHashKey(Map map) 
	{
		if (map.size() <= 0)
		{
			return null;
		}
		return map.keySet().toArray();
	}
	/**
	 * 
	 * @param mobile
	 * @return Date
	 * @throws ParseException
	 */
	public Date stringToDate(String param, String date) throws ParseException 
	{
		SimpleDateFormat format = new SimpleDateFormat(param);
		return format.parse(date);
	}
	// У��绰����
	public static boolean isMobile(String mobile)
	{
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]*$"); // ��֤�ֻ���
		m = p.matcher(mobile);
		b = m.matches();
		return b;
	}
	// У�����֤����
	public static boolean isShenFenZhen(String mobile) 
	{
		Pattern p = null;
		Matcher m = null;
		p = Pattern.compile("^\\p{Punct}{2}$");
		m = p.matcher(mobile);
		boolean b = false;
		b = m.matches();
		return b;
	}
	/**
	 * 
	 * @param message
	 * @param str
	 * @return
	 */
	public static String toAppend(String message, String str)
	{
		StringBuffer buffer = new StringBuffer(message);
		buffer.append(str);
		return buffer.toString();
	}
	public static void main(String[] args) throws Exception
	{
//		InputStream ins = null;
//		String[] cmd = new String[] { "cmd.exe", "/c", "F:\\apache-maven-3.2.5\\bin\\a.bat" }; // ����
//		try
//		{
//			Process process = Runtime.getRuntime().exec(cmd);
//			ins = process.getInputStream(); // ��ȡִ��cmd��������Ϣ
//			BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
//			String line = null;
//			while ((line = reader.readLine()) != null)
//			{
//				System.out.println(line); // ���
//			}
//			int exitValue = process.waitFor();
//			System.out.println("����ֵ��" + exitValue);
//			process.getOutputStream().close(); // ��Ҫ������һ��Ҫ��
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
		
		
		
		new Thread(new Runnable() {
			public boolean writer(String path) throws IOException
			{   
				File f = new File(path);
				Writer writer = new BufferedWriter(new FileWriter(f,true));
				Scanner scanner = new Scanner(System.in);
				String message = scanner.nextLine();
				try
				{
					if(!f.exists())
					{
						f.createNewFile();
					}
					writer.write(message);
					scanner.reset();
				} 
				catch (Exception e)
				{
					System.err.println(e);
					return false;
				}
				finally 
				{
					writer.flush();
					writer.close();
				}
				
				return true;
				
			}
			@Override
			public void run() 
			{
				try
				{
					writer("D:\\sqlWriter");
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}
}