package com.headfirst.pacmanface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTextAreaGui implements ActionListener{

    JTextArea jArea;

    public static void main(String[] args) {
        JTextAreaGui jGui =  new JTextAreaGui();
        jGui.setUpGui();
    }

    void setUpGui(){
        JFrame frame = new JFrame("ComponentsTests frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JButton button = new JButton("Just do it!");
        button.addActionListener(this);

        jArea = new JTextArea(10,20);
        JScrollPane scrollPane = new JScrollPane(jArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scrollPane);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jArea.append("Just did it! \n");
    }
}
