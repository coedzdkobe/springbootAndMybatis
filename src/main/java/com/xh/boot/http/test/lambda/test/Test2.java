package com.xh.boot.http.test.lambda.test;

import com.xh.boot.http.test.lambda.entity.Item;
import com.xh.boot.http.test.lambda.service.ItemCreatorArgs;
import com.xh.boot.http.test.lambda.service.ReturnOneParam;

public class Test2 {
	public static void main(String[] args) {	//lambda表达式的引用
		ReturnOneParam returnOneParam = a -> doubleNum(a);
		System.out.println(returnOneParam.method(3));
		
		//引用已经实现了的方法
		ReturnOneParam simple = Test2::doubleNum;
		System.out.println(simple.method(6));
		
		//对象::方法名
		Test2 t = new Test2();
		ReturnOneParam ref = t::numTwo;
		System.out.println(ref.method(9));
		
		//构造方法的引用
		ItemCreatorArgs itemCreatorArgs = () -> new Item();
		Item item =itemCreatorArgs.getItem();
		item.setName("fxh");
		System.out.println(item.getName());
	}
	
	public static int doubleNum(int a) {
		return a*2;
	}
	
	public int numTwo(int c) {
		return c*3;
	}
}
