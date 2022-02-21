package com.pacmanface.huinder;

import java.lang.reflect.*;

public class NonOwnerInvocationHandler implements InvocationHandler{
	
	PersonBean person;
	
	public NonOwnerInvocationHandler(PersonBean p){
		person = p;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[]args) throws IllegalAccessException{
		try{
			if(method.getName().equals("setHorOrNotRating")) return method.invoke(proxy, args);
			else if(method.getName().startsWith("get")) return method.invoke(proxy, args);
			else if(method.getName().startsWith("set")) throw new IllegalAccessException();
		}catch(InvocationTargetException e){
			e.printStackTrace();
		}
		return null;
	}
}
