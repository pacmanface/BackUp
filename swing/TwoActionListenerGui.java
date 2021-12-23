import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import panels.MyJpanel;


/**
 * TwoButtonGui
 */
public class TwoActionListenerGui {

    JFrame frame;
    JLabel lable;

    public static void main(String[] args) {
        TwoActionListenerGui tGui = new TwoActionListenerGui();
        tGui.go();
    }

    void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
        lable = new JLabel("lable origin");

        JButton colorB = new JButton("color button");
        colorB.addActionListener(new ColorButtonListener());

        JButton lableB = new JButton("lable button");
        lableB.addActionListener(new LableButtonListener());

        frame.getContentPane().add(BorderLayout.WEST,lable);
        frame.getContentPane().add(BorderLayout.EAST,colorB);
        frame.getContentPane().add(BorderLayout.SOUTH,lableB);
        frame.getContentPane().add(BorderLayout.CENTER, new MyJpanel());
        
        frame.setSize(600, 600);
        frame.setVisible(true);
 
    }

    public class ColorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

    public class LableButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lable.setText("performed lable");
        }
        
    }
}