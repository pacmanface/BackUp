import javax.swing.JFrame;

public class TestGui {
    public static void main(String[] args) {
        MyJpanel jpanel = new MyJpanel();
        ImageJPanel iPanel = new ImageJPanel();
        goTest().getContentPane().add(iPanel);
    }

    static JFrame goTest(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 600);
        return frame;
    }
}
