package com.pacmanface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application{

	public static void main(String[]args){	
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IClient client = (IClient) context.getBean("client");
		client.doSomething();
	}
}
