package com.pacmanface;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleApp {
	
	public static void main(String[]args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.pacmanface");
		context.refresh();
		
		Client2 client = (Client2) context.getBean("client1");
		client.doSomething();
 	}

}
