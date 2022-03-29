package com.pacmanface.ted;

import com.google.inject.AbstractModule;

public class TextEditorModule extends AbstractModule{
	@Override
	public void configure(){
		bind(SpellChecker.class).to(SpellCheckerImpl.class);
	}
}
