package com.huawei.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import com.sun.research.ws.wadl.Method;

import scala.annotation.serializable;

public class StringsUtil {
	public String getName() {
		return "";
	}
	public static void main(String[] args) throws Exception {
//		List list = new ArrayList();
//		List list2 = new LinkedList();
//		list.add(new Object());
//		list.add(100);
//		list2.add("100");
//		list2.add(200);
//		for(int index = 0 ;index < list.size();index ++) 
//		{
//			System.out.println(list.get(index));
//		}
//		for(Object object : list) 
//		{
//			System.out.println(object);
//		}
		
		
		
//		File file = new File("F:\\ceshi.txt");
//		if(!file.exists())
//		{
//			file.createNewFile();
//		}
//		Writer writer = new BufferedWriter(new FileWriter(file));
//		writer.write("test !");
//		writer.flush();
//		writer.close();
		
//		Map<String, Object>map = new HashMap<String,Object>();
//		Calendar calendar = Calendar.getInstance();
//		map.put("date", calendar);
//		map.get("date");
//		System.out.println(map.size());
//		Long[]ls = new Long[5];
//		for(int index = 0;index <5;index ++) 
//		{
//			ls[index] = (long) index;
//		}
//		List<Long>  list = Arrays.asList(ls);
//		System.out.println(list.size() + " :size");
//		for(Long l:list)
//		{
//			System.out.println(l.longValue());
//		}
//		List<Integer>list = new Vector<Integer>();
//		list.add(100);
//		list.add(600);
//		list.add(500);
//		Collections.sort(list);
//       	for(int index = 0;index <list.size();index++) 
//       	{
//       		System.out.println(list.get(index));
//       	}
//		
//		Set set = new HashSet<>();
//		set.add(1);
//		set.add("e");
//		set.add("e");
//		List list = new ArrayList<>();
//		list.add("key");
//		list.add('k');
//        set.addAll(list);
//        Iterator<Object>iterator = set.iterator();
//        while (iterator.hasNext()) 
//        {
//           Object object = iterator.next();
//           System.out.println(object);
//		}
		
//11.Iterator
//		Map map = new HashMap<>();
//		map.put("key",new Object());
//		Iterator<String>it = map.keySet().iterator();
//		while (it.hasNext()) {
//               Object object = it.next();
//               System.out.println(object);
//		}
		
  
//12.	Collection
//	   Collection<String>collection = new LinkedList<String>();
//	   collection.add("e");
//	   Iterator<String>it = collection.iterator();
//       while (it.hasNext()) {
//         System.out.println(it.next());		
//	}		
		
		
//13.HashSet		
//		Set<String>set = new HashSet<String>();
//        set.add("100");		
//14.Date
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String da = format.format(date);
//        Date date2 = format.parse(da);
//		System.out.println(da);
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date2);
//        Date date3 = calendar.getTime();
//        System.out.println(date3);
		
//15.	URL
//		URL url = StringsUtil.class.getResource("");
//		InputStream iStream = url.openStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
//		String line = null;
//		while((line = reader.readLine()) != null) 
//		{
//			System.out.println(line);
//		}
//        int i = -1;
//        while((i = iStream.read())!= -1) 
//        {
//        	System.out.println(i);
//        }
//16.Pattern	
//		String message = "test/d/t/z";
//		Pattern pattern = Pattern.compile("/");
//		String[]shuzu = pattern.split(message);
//		for(int index = 0 ; index < shuzu.length;index ++) 
//		{
//			System.out.println(shuzu[index]);
//		}
		
//17.serializable
//		Serializable io = UUID.randomUUID();
//		System.out.println(io);
		
//18.Method
//		Class<?>class1 = Class.forName("com.huawei.util.StringsUtil");
//		java.lang.reflect.Method[] methods = class1.getMethods();
//		for(java.lang.reflect.Method m : methods) {
//			System.out.println(m.getName());
//		}
		
//19.Matcher		
//		Pattern pattern = Pattern.compile("t/");
//		Matcher matcher = pattern.matchoer("test/dog/cat/");
//		while (matcher.find()) {
//			System.out.println(matcher.group());
//		}
		
		
//20.Local
//		Locale locale = Locale.getDefault();
//		System.out.println(locale.getLanguage());
//		System.out.println(locale.getCountry());
		
		
//21.Random
//		Random random = new Random();
//		int index = random.nextInt(100);
//		System.out.println(index);
		
		
//22.Entry

//23.Constructor<T>
//		Class<?>class1 = Class.forName("com.huawei.util.StringsUtil");
//		Constructor[]constructors = class1.getConstructors();
//		for(Constructor c:constructors) 
//		{
//			System.out.println(c.getName());
//		}
		
//24.DateFormat
//		DateFormat format = new SimpleDateFormat("yyyy:MM:dd");
//		Date date = new Date();
//		System.out.println(format.format(date));
		
		
//25.	InetAddress
//		InetAddress address = InetAddress.getLocalHost();
//		System.out.println(address.getHostAddress());
		
		
		
		
		
		
	}

}
