package com.huawei.util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StingUtil {
	// list转数组
	public static <T> Object[] ListParseArray(List<T> list) 
	{
		Object[] o = list.toArray();
		return o;
	}
	// String非空校验
	public static boolean isEmpty(String message) 
	{
		if (message.isEmpty() || message.equals("")) 
		{
			return false;
		}
		return true;
	}
	// Object非空校验
	public static boolean isObjectEmpty(Object o)
	{
		if (o == null) 
		{
			return true;
		}
		return false;
	}
	// 数组转list
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
	// 遍历HashMap
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
	// 返回hashmap key值集合
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
	// 校验电话号码
	public static boolean isMobile(String mobile)
	{
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]*$"); // 验证手机号
		m = p.matcher(mobile);
		b = m.matches();
		return b;
	}
	// 校验身份证号码
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
	public static void main(String[] args) 
	{
		InputStream ins = null;
		String[] cmd = new String[] { "cmd.exe", "/c", "F:\\apache-maven-3.2.5\\bin\\a.bat" }; // 命令
		try
		{
			Process process = Runtime.getRuntime().exec(cmd);
			ins = process.getInputStream(); // 获取执行cmd命令后的信息
			BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line); // 输出
			}
			int exitValue = process.waitFor();
			System.out.println("返回值：" + exitValue);
			process.getOutputStream().close(); // 不要忘记了一定要关
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}