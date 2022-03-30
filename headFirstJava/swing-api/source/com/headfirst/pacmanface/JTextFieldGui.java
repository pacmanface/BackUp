package com.headfirst.pacmanface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JTextFieldGui implements ActionListener {

    JTextField field;
    JCheckBox checkBox;

    public static void main(String[] args) {
        JTextFieldGui tGui = new JTextFieldGui();
        tGui.go();
    }

    void go(){
        JFrame frame = new JFrame("ComponentsTest frame");
        JPanel panel = new JPanel();
        checkBox = new JCheckBox();
        field = new JTextField(30);

        checkBox.addItemListener(new CheckBoxItemListener());;
        field.addActionListener(this);
        field.requestFocus();

        panel.add(field);
        panel.add(checkBox);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(field.getText());
    }

    public class CheckBoxItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (checkBox.isSelected()) {
                field.setText("checkboxed text");
                checkBox.setSelected(false);
            } 
        }
    }
}
