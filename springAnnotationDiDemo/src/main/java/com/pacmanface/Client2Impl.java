package com.pacmanface;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("client1")
public class Client2Impl implements Client2{
	
	@Autowired
	private	Service2 service;
	
	public void doSomething(){
		String message = service.getInfo();
		System.out.println(message);
	}	
}
