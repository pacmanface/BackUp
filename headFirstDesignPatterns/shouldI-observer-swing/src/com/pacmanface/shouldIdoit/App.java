package com.pacmanface.shouldIdoit;

import java.awt.*;
//import java.awt.Event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Should I do it frame");
        JButton button = new JButton("Should I do it?");
        button.addActionListener(e-> System.out.println("Fuck do it!"));
        button.addActionListener(e-> System.out.println("Don't do that brother!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.getContentPane().add(BorderLayout.CENTER, button);
    }
}
