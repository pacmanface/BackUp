package com.headfirst.pacmanface;

import java.awt.*;
import javax.swing.*;

class FlowLayoutGui{
    
    public static void main(String[] args){
        FlowLayoutGui gui = new FlowLayoutGui();
        gui.go();
    }

    void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton buttOne = new JButton("shok me!");
        JButton buttTwo = new JButton("bliss");
        JButton buttThree = new JButton("huh");

        panel.setBackground(Color.yellow);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(buttOne);
        panel.add(buttTwo);
        panel.add(buttThree);

        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

}
