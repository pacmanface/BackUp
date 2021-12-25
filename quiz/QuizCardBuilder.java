import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }
    
    void go(){
        frame = new JFrame("Quiz Card Builder");
        JPanel panel = new JPanel();
        Font bigFont = new Font("Sancerif", Font.BOLD, 24);
        question = new JTextArea(6,20);
        question.setFont(bigFont);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);

        JScrollPane qScroller = JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        answer = new JTextArea(6,20);
        answer.setFont(bigFont);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton nextButton = new JButton("Next Card");
        cardList = new ArrayList<>();
        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");

        panel.add(qLabel);
        panel.add(qScroller);
        panel.add(aLabel);
        panel.add(aScroller);
        panel.add(nextButton);

        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(600, 600);
        frame.setVisible(true);


    }

    public class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    public class SaveMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    public class NewMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }

    private void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
    
    private void saveFile(File file){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (QuizCard quizCard : cardList) {
                writer.write(quizCard.getQuestion() + "/");
                writer.write(quizCard.getAnswer() + "\n");                
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("couldn't write the cardList out!");
            e.printStackTrace();
        }
    }


}
