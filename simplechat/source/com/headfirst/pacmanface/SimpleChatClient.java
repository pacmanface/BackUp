import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        SimpleChatClient simpleChatClient = new SimpleChatClient();
        simpleChatClient.setUpGui();        
    }

    void setUpGui(){
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel panel = new JPanel();
        outgoing = new JTextField(20);
        incoming = new JTextArea(20,50);
        JScrollPane scrollPane = new JScrollPane(incoming);
        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new MySendButtonListener());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        incoming.setLineWrap(true);
        incoming.setEditable(false);
        incoming.setWrapStyleWord(true);
        panel.add(outgoing);
        panel.add(scrollPane);
        panel.add(sendButton);

        setUpNetWorking();

        Thread thread = new Thread(new IncomingReader());
        thread.start();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(350, 100);
        frame.setVisible(true);
    }

    void setUpNetWorking(){
        try {
            socket = new Socket("127.0.0.1",5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networking established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class MySendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read "+message);
                    incoming.append(message+"\n");
                }                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
