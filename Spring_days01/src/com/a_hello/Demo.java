package com.a_hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;

public class Demo {
	@Test
	public void fin1() {
		
		// 1.��������
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user");
		// 3.��ӡuser����
		System.out.println(u);
	}
}
