package com.xh.boot.http.test.lambda.test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {	//lambda表达式创建线程
			for(int i=0;i<10;i++) {
				System.out.println(i);
			}
		}); 
		t.start();
		
		//遍历集合
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.forEach(System.out::println);
		
		list.forEach(e -> System.out.println(e));
	}
}
