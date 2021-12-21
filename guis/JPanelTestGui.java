import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

import panels.ImageJPanel;
import panels.MyJpanel;

public class JPanelTestGui implements ActionListener {
    public static void main(String[] args) {
        JPanelTestGui jTestGui = new JPanelTestGui();
        jTestGui.go();
    }

    void go(){
        MyJpanel jpanel = new MyJpanel();

        ImageJPanel iPanel = new ImageJPanel();

        JButton button = new JButton("change something");
        button.addActionListener(this);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(BorderLayout.WEST, iPanel);
        frame.getContentPane().add(BorderLayout.CENTER, jpanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
