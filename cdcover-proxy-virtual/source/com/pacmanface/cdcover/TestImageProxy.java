package com.pacmanface.cdcover;

import java.net.*;
import java.awt.*;
import java.awt.Event.*;
import java.util.*;
import javax.swing.*;

public class TestImageProxy{
	
	ImageComponent component;
	JFrame frame = new JFrame("CD Cover Viewer");
	JMenuBar menuBar;
	JMenu menu;
	HashMap<String,String> pictures = new HashMap<>();
	
	public static void main(String[]args){
		new TestImageProxy();
	}
	
	public TestImageProxy() throws Exception {
		pictures.put("","");
		
		URL url = new URL(pictures.get(""));
		menuBar = new JMenuBar();
		menu = new JMenu("Pictures");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		for(String s: pictures.keySet()){
			JMenuItem item = new JMenuItem(s);
			menu.add(item);
			item.addActionListener(e->{
				component.setIcon(new ImageProxy(getUrl(e.getActionCommand())));
				frame.repaint();
			});
		}
		
		Icon icon = new ImageProxy(url);
		component = new ImageComponent(icon);
		frame.getContentPane().add(component);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	
	URL getUrl(String s){
		try{
			return new URL(pictures.get(s));	
		}catch(MalformedURLException e){
			e.printStackTrace();
			return null;
		}
	}
}
