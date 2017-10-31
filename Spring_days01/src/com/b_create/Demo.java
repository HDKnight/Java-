package com.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;

public class Demo {
	@Test
	//������ʽһ���ղι���
	public void fun1() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\b_create\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user");
		// 3.��ӡuser����
		System.out.println(u);
	}
	
	//������ʽ������̬��������
	@Test
	public void fun2() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\b_create\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user2");
		// 3.��ӡuser2����
		System.out.println(u);
	}
	
		//������ʽ����ʵ����������
		@Test
		public void fun3() {
			// 1.������������
			ApplicationContext ac = new ClassPathXmlApplicationContext("com\\b_create\\applicationContext.xml");
			// 2.������Ҫuser����
			User u= (User)ac.getBean("user3");
			// 3.��ӡuser2����
			System.out.println(u);
		}
		
		//�����������ڷ���
		@Test
		public void fun4() {
			// 1.������������
			ApplicationContext ac = new ClassPathXmlApplicationContext("com\\b_create\\applicationContext.xml");
			// 2.������Ҫuser����
			User u= (User)ac.getBean("user");
			// 3.��ӡuser2����
			System.out.println(u);
			//�ر��������������ٷ���
			((AbstractApplicationContext) ac).close();
		}
		
	
}
