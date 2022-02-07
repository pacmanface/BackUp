package com.pacmanface.templatebeverage;

import java.io.*;

class GreenTea extends HotBeverage{
	public void brew(){
		System.out.println("brew the perfect green tea");
	}
	public void addCondiment(){
		System.out.println("add the bitter lemon slice to the tea.");
	}
	
	@Override
	public boolean isAddCondiment(){
		System.out.println("Do you want any condiments for your tea?");
		String answear = null;
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
			answear = reader.readln();
		}catch(Exception e){
			e.printStackTrace();
		}
		return answear==null?false:answear.toLowerCase().startsWith("y")?true:false;
	}
}
