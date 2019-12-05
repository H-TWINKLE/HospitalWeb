package com.gy.common.interceptor;

import com.gy.common.entity.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class GobalInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation arg0) {

		Controller c = arg0.getController();

		User u = c.getSessionAttr("user");

		if (u == null) {
			c.forwardAction("/login");
			return;
		}

		//printLn(u);

		arg0.invoke();

	}

	protected void printLn(User u) {
		System.out.println("GobalInterceptor printLn: 当前用户：------------------------------------\n");
		System.out.println(u);
		System.out.println("\n------------------------------------");
	}
	
	

}
