import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InnerClassGui implements ActionListener {

    InnerJPanel panel;
    JButton button;
    int x,y;

    public static void main(String[] args) {
        InnerClassGui jTestGui = new InnerClassGui();
        jTestGui.go();
    }

    void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new InnerJPanel();
        button = new JButton("Саввуся, жми кнопку");
        JLabel label = new JLabel("Здесь будет цвет!");
        
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.NORTH,label);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = (int) (Math.random()*350);
        y = (int) (Math.random()*350);
        panel.repaint();
        button.setText("Нажато "+x+" "+y);
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
