import javax.swing.*;
import java.awt.event.*;

/**
 * SimpleGUI
 */
public class SimpleGUI implements ActionListener {

    JButton button;

    public static void main(String[] args) {
        SimpleGUI sGui = new SimpleGUI();
        sGui.go();
    }

    void go(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("click me");
        button.addActionListener(this);

        jFrame.getContentPane().add(button);
        jFrame.setSize(300, 300);  
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("already clicked");       
    }

}