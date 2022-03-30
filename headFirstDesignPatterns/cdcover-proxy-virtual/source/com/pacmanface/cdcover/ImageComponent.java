package com.pacmanface.cdcover;

import java.awt.*;
import javax.swing.*;

public class ImageComponent extends JComponent{
	private Icon icon;
	
	public ImageComponent(Icon i){
		icon = i;
	}
	
	public void setIcon(Icon i){
		icon = i;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int w = icon.getIconWidth();
		int h = icon.getIconHeight();
		int x = (800-w)/2;
		int y = (600-h)/2;
		icon.paintIcon(this,g,x,y);
	}		
}
