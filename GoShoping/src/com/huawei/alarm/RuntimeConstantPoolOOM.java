package com.huawei.alarm;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		// 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB 的 PermSize 在 integer 范围内足够产生 OOM 了
		int i = 0;
		while (true) {
		list.add(String.valueOf(i++).intern());
		}
		}

}
