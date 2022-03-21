package com.pacmanface;

import org.springframework.stereotype.Component;

@Component("service2")
public class Service2Impl implements Service2{
	
	public String getInfo(){
		return "service message from Service2Impl!";
	} 
}
