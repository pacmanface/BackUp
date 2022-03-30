package com.headfirst.pacmanface;

import javax.sound.midi.*;

public class MiniMusicPlayer {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence sequence = new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();

            for (int i = 5; i <61; i+=4) {
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));    
            }

            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    static MidiEvent makeEvent(int... cmds){
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
