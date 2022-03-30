package com.pacmanface.cdcover;

import java.net.*;
import java.awt.*;
import javax.swing.*;

public class ImageProxy implements Icon{
	
	volatile ImageIcon icon;
	final URL url;
	Thread thread;
	boolean retrieving = false;
	
	public ImageProxy(URL u){
		url = u;
	}
	
	@Override
	public int getIconWidth(){
		return icon == null ? 800 : icon.getIconWidth();
	}
	
	@Override
	public int getIconHeight(){
		return icon == null ? 600 : icon.getIconHeight();
	}
	
	public void setImageIcon(ImageIcon i){
		icon = i;
	}
	
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y){
		if(icon!=null) icon.paintIcon(c,g,x,y);
		else{
			g.drawString("Loading the picture, please wait",x+300,y+190);
			if(!retrieving){
				retrieving = true;
				thread = new Thread(new Runnable(){
					public void run(){
						try{
							setImageIcon(new ImageIcon(url,"some picture"));		
						}catch(Exception e){
							e.printStackTrace();
						}
					}					
				});
				thread.start();
			}
		}
	}	
}


