package com.pacmanface.componentcafe;

import java.util.Iterator;
import com.pacmanface.componentcafe.iterators.*;

public class MenuItem extends Component{
	
	public boolean isVegetarian;
	public double price;
	
	public MenuItem(String n, String d, boolean b, double p){
		name=n;
		description=d;
		isVegetarian=b;
		price=p;
	}
	
	@Override
	public boolean isVegan() {
		return isVegetarian;
	}

	@Override
	public void print(){
		System.out.println(this.toString());
	}

	@Override
	public String toString(){
		return name+" "+description+" "+isVegetarian+" "+price;
	}

	@Override
	public Iterator<Component> createIterator() {
		return new NullIterator();
	}
}
