package com.pacmanface.ted;

//import com.google.inject.AbstractModule;
import com.google.inject.Injector;
//import com.google.inject.Inject;
import com.google.inject.Guice;

public class TestEditor{
	public static void main(String[]args){
		Injector injector = Guice.createInjector(new TextEditorModule());
		TextEditor ted = injector.getInstance(TextEditor.class);
		ted.edit();		
	}
}
