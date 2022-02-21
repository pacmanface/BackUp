package com.pacmanface.huinder;

public class PersonBeanImpl implements PersonBean {
	
	private String name;
	private String gender;
	private String interests;
	private int rating = 0;
	private int ratingCount = 0;
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getGender(){
		return gender;
	}
	
	@Override
	public String getInterests(){
		return interests;
	}
	
	@Override
	public int getHotOrNotRating(){
		return rating == 0 ? 0 : (int)rating/ratingCount;
	}
	
	@Override
	public void setName(String n){
		name = n;
	}
	
	@Override
	public void setGender(String g){
		gender = g;
	}
	
	@Override
	public void setInterests(String i){
		interests = i;
	}
	
	@Override
	public void setHotOrNotRating(int r){
		if(r>0){ 
			rating+=r;
			ratingCount++;
		}
	}
}
