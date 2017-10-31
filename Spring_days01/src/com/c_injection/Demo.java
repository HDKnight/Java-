package com.c_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.User;

public class Demo {
	/**
	 * ������ʽһ���ղι���
	 */
	@Test
	public void fun1() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\c_injection\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user");
		// 3.��ӡuser����
		System.out.println(u);
	}
	/**
	 * ���캯��ע��
	 */
	@Test
	public void fun2() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\c_injection\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user2");
		// 3.��ӡuser����
		System.out.println(u);
	}
	/**
	 *  P����ע�뷽ʽ: ��set����
	 */
	@Test
	public void fun3() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\c_injection\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user3");
		// 3.��ӡuser����
		System.out.println(u);
	}
	/**
	 * spelע�룺spring Expression Language spring���ʽ����
	 */
	@Test
	public void fun4() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\c_injection\\applicationContext.xml");
		// 2.������Ҫuser����
		User u= (User)ac.getBean("user4");
		// 3.��ӡuser����
		System.out.println(u);
	}
	/**
	 *  �������͹�ע��
	 */
	@Test
	public void fun5() {
		// 1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("com\\c_injection\\applicationContext.xml");
		// 2.������Ҫuser����
		CollectionBean cb= (CollectionBean)ac.getBean("cb");
		// 3.��ӡuser����
		System.out.println(cb);
	}
}
