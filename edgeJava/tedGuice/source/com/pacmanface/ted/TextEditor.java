package com.pacmanface.ted;

import javax.inject.*;

public class TextEditor{
	public SpellChecker checker;
	
	@Inject
	public TextEditor(SpellChecker s){
		checker = s;
	}
	
	public void edit(){
		checker.check();
	}
}
