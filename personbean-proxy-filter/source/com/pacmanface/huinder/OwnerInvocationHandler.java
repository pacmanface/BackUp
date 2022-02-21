package com.pacmanface.huinder;

import java.lang.reflect.*;

public class OwnerInvocationHandler implements InvocationHandler{
	
	PersonBean person;
	
	public OwnerInvocationHandler(PersonBean p){
		person = p;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[]args) throws IllegalAccessException{
		try{
			if(method.getName().startsWith("get")) return method.invoke(proxy, args);
			else if(method.getName().equals("setHorOrNotRating")) throw new IllegalAccessException();
			else if(method.getName().startsWith("set")) return method.invoke(proxy, args);
		}catch(InvocationTargetException e){
			e.printStackTrace();
		}
		return null;
	}
}
