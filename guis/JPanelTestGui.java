import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.MyJpanel;

import java.awt.event.*;
import java.awt.*;

public class JPanelTestGui implements ActionListener {

    JFrame frame;
    InnerJPanel panel;
    JButton button;
    MyJpanel myJpanel;

    int x;
    int y;

    public static void main(String[] args) {
        JPanelTestGui jTestGui = new JPanelTestGui();
        jTestGui.go();
    }

    void go(){
        frame = new JFrame();
        panel = new InnerJPanel();
        myJpanel = new MyJpanel();
        button = new JButton("change something");
        
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, myJpanel);
        //frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = (int) (Math.random()*350);
        y = (int) (Math.random()*350);
        myJpanel.setXY(x, y);
        myJpanel.repaint();
        //panel.repaint();
        button.setText("done! "+x+" "+y);
    }

    public class InnerJPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 100, 100);
        }
    }
}
