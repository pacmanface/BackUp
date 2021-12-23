import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.midi.*;

public class BeatBox {
    JFrame frame;
    JPanel panel;
    ArrayList<JCheckBox> cList;
    Sequence seq;
    Sequencer sequencer;
    Track track;
    JLabel label;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
                                "Hand Clap", "High Tom", "High Bongo", "Maracas", "Whistle", "Low Conga",
                                "Cowbell", "Vibraslap", "Low-mid Tom", "Hi Agogo", "Open Hi Conga"};
    
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    void buildGUI(){
        frame = new JFrame("Cyber beatbox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel backgroung = new JPanel(layout);
        backgroung.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        cList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton upTempo = new JButton("Tempo Up");
        JButton downTempo = new JButton("Tempo Down");
        label = new JLabel("tempo is ");

        start.addActionListener(new MyStartListener());
        stop.addActionListener(new MyStopListener());
        upTempo.addActionListener(new MyUpTempoListener());
        downTempo.addActionListener(new MyDownTempoListener());

        buttonBox.add(start);
        buttonBox.add(stop);
        buttonBox.add(upTempo);
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String name: instrumentNames) {
            nameBox.add(new JLabel(name));
        }

        backgroung.add(BorderLayout.WEST, nameBox);
        backgroung.add(BorderLayout.EAST, buttonBox);
        backgroung.add(BorderLayout.SOUTH, label);

        frame.getContentPane().add(backgroung);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        panel = new JPanel(grid);

        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            cList.add(checkBox);
            panel.add(checkBox);
        }
        
        backgroung.add(BorderLayout.CENTER,panel);

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    void buildTrackAndStart(){
        int[] trackList = null;
        seq.deleteTrack(track);
        track = seq.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) cList.get(j+(16*i));
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
            sequencer.setSequence(seq);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
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
            seq = new Sequence(Sequence.PPQ,4);
            track = seq.createTrack();
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
            label.setText("tempo is "+tempoFactor);
        }
    }

    class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            tempoFactor*=0.97;
            sequencer.setTempoFactor(tempoFactor);
            label.setText("tempo is "+tempoFactor);
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

