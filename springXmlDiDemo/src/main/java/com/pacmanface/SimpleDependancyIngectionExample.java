package com.pacmanface;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleDependancyIngectionExample {
	public static void main(String[]args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Client client = (Client) ctxt.getBean("client1");
		client.doSomething();
	}
}
