package com.b_create;

import com.bean.User;

public class UserFactory {
	public static User createUser() {
		
		System.out.println("��̬��������");

		return new User();
	}
	
	public User createUser2() {
		
		System.out.println("ʵ����������User");
		
		return new User();
	}

}
