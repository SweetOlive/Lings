package com.lings;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.zhoufy")
public class Demo {

	@Test
	public void test() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

		System.out.println("静态方法语法");
		//静态方法语法	ClassName::methodName
		list.forEach(Demo::prints);

		System.out.println("对象实例语法");
		//对象实例语法	instanceRef::methodName
		list.forEach(new Demo()::print);
	}
	
	public static void prints(String content){
		System.out.println(content);
	}

	public  void print(String content){
		System.out.println(content);
	}
}
