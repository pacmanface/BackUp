package com.pacmanface;

public class IClientImpl implements IClient{

	private IService service;
	
	public IClientImpl(IService service){
		this.service = service;
	}

	public void doSomething(){
		String message = service.getInfo();
		System.out.println(message);
	}
}
