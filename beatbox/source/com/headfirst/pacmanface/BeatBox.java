package com.headfirst.pacmanface;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;

public class BeatBox {
    JFrame frame;
    JPanel panel;
    ArrayList<JCheckBox> checkBoxList;
    JLabel tempoLabel;
    JTextField messageTextField;
    JList<String> incomingMessagesList;
    Sequence sequence;
    Sequencer sequencer;
    Track track;
    ObjectOutputStream out;
    ObjectInputStream in;
    String userName;
    int nextNum;
    Vector<String> vector = new Vector<>();
    HashMap<String,boolean[]> messageAndSequenceMap = new HashMap<>();


    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
                                "Hand Clap", "High Tom", "High Bongo", "Maracas", "Whistle", "Low Conga",
                                "Cowbell", "Vibraslap", "Low-mid Tom", "Hi Agogo", "Open Hi Conga"};
    
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        new BeatBox().startUp("petya");
    }

    public void startUp(String name){
        userName = name;
        try (Socket socket = new Socket("127.0.0.1",5000)){
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();
        } catch (Exception ex) {
            System.out.println("Sorry dude, server connection false, play alone");
            ex.printStackTrace();
        }
        setUpMidi();
        buildGUI();
    }

    void buildGUI(){
        frame = new JFrame("Cyber beatbox");
        BorderLayout layout = new BorderLayout();
        JPanel backgroung = new JPanel(layout);
        backgroung.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        checkBoxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");

        JButton stop = new JButton("Stop");
        JButton upTempo = new JButton("Tempo Up");
        JButton downTempo = new JButton("Tempo Down");
        JButton save = new JButton("SaveBeats");
        JButton open = new JButton("OpenBeats");
        JButton sendIt = new JButton("Send It");

        tempoLabel = new JLabel("tempo is ");
        messageTextField = new JTextField();
        incomingMessagesList = new JList<>();
        incomingMessagesList.addListSelectionListener(new MyListSelectionListener());
        incomingMessagesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane incomingMessageScrollPane = new JScrollPane(incomingMessagesList);

        start.addActionListener(new MyStartListener());
        stop.addActionListener(new MyStopListener());
        upTempo.addActionListener(new MyUpTempoListener());
        downTempo.addActionListener(new MyDownTempoListener());
        save.addActionListener(new MySaveListener());
        open.addActionListener(new MyOpenListener());
        sendIt.addActionListener(new MySendItListener());

        buttonBox.add(start);
        buttonBox.add(stop);
        buttonBox.add(upTempo);
        buttonBox.add(downTempo);
        buttonBox.add(save);
        buttonBox.add(open);
        buttonBox.add(sendIt);
        buttonBox.add(messageTextField);
        buttonBox.add(incomingMessageScrollPane);
        buttonBox.add(tempoLabel);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String name: instrumentNames) {
            nameBox.add(new JLabel(name));
        }

        backgroung.add(BorderLayout.WEST, nameBox);
        backgroung.add(BorderLayout.EAST, buttonBox);
        frame.getContentPane().add(backgroung);
        GridLayout checkBoxGrid = new GridLayout(16,16);
        checkBoxGrid.setVgap(1);
        checkBoxGrid.setHgap(2);
        panel = new JPanel(checkBoxGrid);

        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            checkBoxList.add(checkBox);
            panel.add(checkBox);
        }
        
        backgroung.add(BorderLayout.CENTER,panel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    void buildTrackAndStart(){
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkBoxList.get(j+(16*i));
                if(jc.isSelected()){
                    trackList[j] = key;
                }else{
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }
        track.add(makeEvent(192,9,1,0,15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setUpMidi(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyStartListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            buildTrackAndStart();
        }
    }

    class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sequencer.stop();
        }
    }

    class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            tempoFactor*=1.03;
            sequencer.setTempoFactor(tempoFactor);
            tempoLabel.setText("tempo is "+tempoFactor);
        }
    }

    class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            tempoFactor*=0.97;
            sequencer.setTempoFactor(tempoFactor);
            tempoLabel.setText("tempo is "+tempoFactor);
        }
    }

    public class MySaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!checkBoxList.isEmpty()){
                boolean[] checkFlag = new boolean[256];
                int i = 0;
                for (JCheckBox jCheckBox : checkBoxList) {
                    checkFlag[i] = jCheckBox.isSelected();
                    i++;
                } 
                try {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showSaveDialog(frame);
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));
                    os.writeObject(checkFlag);
                    os.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }   
        }
    }

    public class MyOpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkFlag = null;
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(frame);
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
                checkFlag = (boolean[]) is.readObject();
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(checkFlag != null){
                for (int i = 0; i < 256; i++) {
                    JCheckBox cBox = checkBoxList.get(i);
                    cBox.setSelected(checkFlag[i]);
                }
                frame.repaint();
            }
        }
    }

    public class MySendItListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkBoxState = new boolean[256];
            for (int i = 0; i < checkBoxState.length; i++) {
                JCheckBox checkBox = checkBoxList.get(i);
                if(checkBox.isSelected()){
                    checkBoxState[i]=true;
                }
            }
            //String messageToSend = null;
            try {
                out.writeObject(userName+nextNum++ +": "+messageTextField.getText());
                out.writeObject(checkBoxState);
            } catch (Exception ex) {
                System.out.println("Sorry dude, we can't send message!");
                ex.printStackTrace();
            }
            messageTextField.setText("");
        }
    }

    public class MyListSelectionListener implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent le) {
            if(!le.getValueIsAdjusting()){
                String selected = incomingMessagesList.getSelectedValue();
                if(selected!=null){
                    boolean[] selectedState = messageAndSequenceMap.get(selected);
                    changeSequence(selectedState);
                    sequencer.stop();
                    buildTrackAndStart();
                }
            }
        }
    }

    public class RemoteReader implements Runnable{
        Object object = null;
        String nameToShow = null;
        boolean[] checkBoxState = null;
        
        @Override
        public void run() {
            try {
                while((object = in.readObject()) != null){
                    System.out.println("got an object from server");
                    System.out.println(object.getClass());
                    nameToShow = (String) object;
                    checkBoxState = (boolean[]) in.readObject();
                    messageAndSequenceMap.put(nameToShow, checkBoxState);
                    vector.add(nameToShow);
                    incomingMessagesList.setListData(vector);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }            
        }
    }

    public class MyPlayMineListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //if(mySequence != null) sequence = mySequence;
        }
        
    }

    public void changeSequence(boolean[] selectecState){
        for (int i = 0; i < selectecState.length; i++) {
            JCheckBox checkBox = checkBoxList.get(i);
            if(selectecState[i]=true) checkBox.setSelected(true);
            else checkBox.setSelected(false);
        }
    }

    void makeTracks(int... list){
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if(key!=0){
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }   
    }

    MidiEvent makeEvent(int... cmds){
        MidiEvent event = null;
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(cmds[0], cmds[1], cmds[2], cmds[3]);
            event = new MidiEvent(message, cmds[4]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}

