package com.headfirst.pacmanface;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyJpanel extends JPanel {

    private int x;
    private int y;

    public void setXY(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 100, 100);
    }
}