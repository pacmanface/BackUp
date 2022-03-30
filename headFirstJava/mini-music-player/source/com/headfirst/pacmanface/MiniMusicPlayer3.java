package com.headfirst.pacmanface;

import javax.sound.midi.*;
import java.awt.*;
import javax.swing.*;

public class MiniMusicPlayer3 {
    JFrame frame;
    MyInnerJPanel panel;

    public static void main(String[] args) {
        MiniMusicPlayer3 mPlayer3 = new MiniMusicPlayer3();
        mPlayer3.go();
    }

    void setUpGui(){
        frame = new JFrame("wow I can write here");
        panel = new MyInnerJPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    void go(){
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
                for (int i = 5; i <61; i+=4) {
                    track.add(makeEvent(144,1,i,100,i));
                    track.add(makeEvent(176,1,127,0,i));
                    track.add(makeEvent(128,1,i,100,i+2));    
                }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public class MyInnerJPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;
    
        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if(msg){
            int rr = (int)(Math.random()*250);
            int gg = (int)(Math.random()*250);
            int bb = (int)(Math.random()*250);
            g.setColor(new Color(rr,gg,bb));
            int x = (int) (Math.random()*100);
            int y = (int) (Math.random()*100);
            int width = (int) (Math.random()*100);
            int height = (int) (Math.random()*100);
            g.fillRect(x, y, width, height);
            msg = false;
            }
        }
    }
}
