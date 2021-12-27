import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QuizCardPlayer {

    //private JTextArea answer;
    private JTextArea display;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private boolean isShowAnswer;
    private JFrame frame;
    private JButton nextButton;

    public static void main(String[] args) {
        QuizCardPlayer player = new QuizCardPlayer();
        player.go();
    }

    void go(){
        frame = new JFrame("Quiz Card Player");
        JPanel panel = new JPanel();
        Font sanserif24 = new Font("sanserif", Font.BOLD, 24);
        display = new JTextArea(6,20);
        
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setFont(sanserif24);

        JScrollPane dScroller = new JScrollPane(display);
        dScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        nextButton = new JButton("Show Question");
        nextButton.addActionListener(new NextCardListener());

        panel.add(display);
        panel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");

        openMenuItem.addActionListener(new OpenMenuListener());

        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(540, 600);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            }else{
                if(currentCardIndex<cardList.size()){showNextCard();}
                else{
                    display.setText("No more cards");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    public class OpenMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(frame);
            loadFile(chooser.getSelectedFile());
        }
    }

    private void loadFile(File file){
        cardList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line= reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("couldn't read the card file");
            e.printStackTrace();
        }
    }

    private void makeCard(String lineToParse){
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("the card made");
    }

    private void showNextCard(){
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show next Answer");
        isShowAnswer = true;
    }
}
