package com.huawei.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMatcher {

	public static void main(String[] args) {
		String line = "zyw,--MFK/, 009-AK86/5495zwo ,291:236,294:236";
		String pattern = "29\\d++:236";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		while (m.find()) 
		{
			System.out.println(m.group());
		}
	}
		
	}

