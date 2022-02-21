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
		try{
			new TestImageProxy();
		}catch(Exception e){e.printStackTrace();}
	}
	
	public TestImageProxy() throws Exception {
		pictures.put("yellowstone","https://bigfoto.com/wp-content/uploads/2020/03/yellowstone-national-park-1589616_1280-800x445.jpg");
		pictures.put("yalta","https://bigfoto.com/wp-content/uploads/2020/11/yalta-3984207_1280-800x445.jpg");
		pictures.put("castle","https://bigfoto.com/wp-content/uploads/2020/11/exeter-2917470_1280-800x445.jpg");
		
		URL url = new URL(pictures.get("yellowstone"));
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
