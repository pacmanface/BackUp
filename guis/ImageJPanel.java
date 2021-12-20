import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageJPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Image image = new ImageIcon("/home/pacmanface/Pictures/external-content.duckduckgo.com.jpg").getImage();
        g.drawImage(image, 10,10,this);
    }
}
