package com.lings;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.zhoufy")
public class Example extends BaseExample{

	@Test
	public void test() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

		System.out.println("对象的超类方法语法");
		//对象的超类方法语法： super::methodName 
		list.forEach(super::print);
	}
}

class BaseExample {
	public void print(String content){
		System.out.println(content);
	}
}
