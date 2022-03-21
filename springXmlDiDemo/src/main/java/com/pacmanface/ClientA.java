package com.pacmanface;

public class ClientA implements Client {
	
	Service service;
	
	public ClientA(Service service){
		this.service = service;
	}

	public void doSomething() {
		String message = service.getInfo();
		System.out.println(message);
	}
	
	public void setService(Service service) {
		this.service = service;
	}
}
