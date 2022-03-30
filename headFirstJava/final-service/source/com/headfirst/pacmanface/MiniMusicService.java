package com.headfirst.pacmanface;

import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.*;

public class MiniMusicService implements MyService{
    
    MyDrawPanel myPanel;

    @Override
    public JPanel getGuiPanel() {
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playItButton = new JButton("Play it");
        playItButton.addActionListener(new PlayItListener());
        mainPanel.add(myPanel);
        mainPanel.add(playItButton);
        return mainPanel;
    }

    public class PlayItListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();
                sequencer.addControllerEventListener(myPanel, new int[]{127});
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();
                
                for (int i = 0; i <100; i+=4) {
                    int rNum = (int)((Math.random()*50)+1);
                    if(rNum<38){
                        track.add(makeEvent(144,1,i,100,i));
                        track.add(makeEvent(176,1,127,0,i));
                        track.add(makeEvent(128,1,i,100,i+2));  
                    }  
                }
                sequencer.setSequence(seq);
                sequencer.setTempoInBPM(220);
                sequencer.start();
            } catch (Exception ex) {
                ex.printStackTrace();
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
    
    public class MyDrawPanel extends JPanel implements ControllerEventListener {
        boolean msg = false;
    
        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300,300);
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
