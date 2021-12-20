import javax.swing.*;
import java.awt.event.*;

/**
 * SimpleGUI
 */
public class SimpleGUI implements ActionListener {

    JButton button;
    JFrame jFrame;

    public static void main(String[] args) {
        
        SimpleGUI sGui = new SimpleGUI();
        sGui.go();

    }

    void go(){
        jFrame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(button);
        jFrame.setVisible(true);
        jFrame.setSize(300, 300);        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("already clicked");       
    }

}