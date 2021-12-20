import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * MyJpanel
 */
public class MyJpanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(20, 50, 100, 100);
    }

    
}