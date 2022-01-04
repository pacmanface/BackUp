import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleChatClientA {

    PrintWriter pWriter;
    JTextField textField;
    Socket socket;

    public static void main(String[] args) {
        new SimpleChatClientA().setUpGui();
    }

    void setUpGui(){
        JFrame frame = new JFrame("Simple Chat Client A");
        JPanel panel = new JPanel();
        textField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new MySendListener());
        panel.add(textField);
        panel.add(sendButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setUpConnection();
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    void setUpConnection(){
        try {
            socket = new Socket("127.0.0.1",4242);
            pWriter = new PrintWriter(socket.getOutputStream());
            System.out.println("Connection established!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MySendListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pWriter.println(textField.getText());
                pWriter.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            textField.setText("");
            textField.requestFocus();
        }
    }
    
}
