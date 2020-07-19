package com.xh.boot.http.test.lambda.test;

import com.xh.boot.http.test.lambda.service.NoReturnMulitParam;
import com.xh.boot.http.test.lambda.service.NoReturnNoParam;
import com.xh.boot.http.test.lambda.service.NoReturnOneParam;
import com.xh.boot.http.test.lambda.service.ReturnNoParam;
import com.xh.boot.http.test.lambda.service.ReturnOneParam;

public class Test1 {
	public static void main(String[] args) {
		//
		NoReturnNoParam noReturnNoParam = () -> {
			System.out.println("无参无返回体");
		};
		noReturnNoParam.method();
		
		//
		NoReturnOneParam noReturnOneParam = (int a) -> { //简化参数类型，int可以不写 如果只有一个参数可以不写小括号
			System.out.println("一个参数无返回体"+a);
		};
		noReturnOneParam.method(11);
		
		NoReturnOneParam simple = a -> { //简化参数类型，int可以不写 如果只有一个参数可以不写小括号
			System.out.println("一个参数无返回体简化"+a);
		};
		simple.method(11);
		
		//
		NoReturnMulitParam noreturnMulitParam = (int a,int b) -> {
			System.out.println("多个参数无返回体"+a+"---"+b);
		};
		noreturnMulitParam.method(11,12);
		
		//
		ReturnNoParam returnNoParam = () -> {
			System.out.println("无参，有返回值");
			return 22;
		};
		System.out.println(returnNoParam.method());
		
		//
		ReturnOneParam returnOneParam = (int a) -> { //如果方法体只有一条语句，并且是return语句，可以省略方法体的大括号
			System.out.println(a);
			return 33;
		};
		System.out.println(returnOneParam.method(123));
		
		ReturnOneParam simpleReturn = a -> a+3;				
		System.out.println(simpleReturn.method(66));
		
		
		
		//
	}
}
