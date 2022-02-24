package com.pacmanface.djmvc;

import javax.sound.midi.*;
import java.util.*;

public class BeatModel implements BeatModelInterface, MetaEventListener{
    Sequencer sequencer;
    Track track;
    Sequence sequence;

    ArrayList<BeatObserver> beats = new ArrayList<>();
    ArrayList<BPMObserver> bpms = new ArrayList<>();
    int bpm = 90;

    @Override
    public void registerObserver(BPMObserver o) {
        bpms.add(o);
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beats.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int i = bpms.indexOf(o);
        if(i>-1) bpms.remove(i);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int i = beats.indexOf(o);
        if(i>-1) beats.remove(i);
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObserver();
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void on() {
        System.out.println("Starting the sequencer");
        setBPM(90);
        sequencer.start();
    }

    @Override
    public void init() {
        setUpMidi();
        buildTrackAndStart();
    }

    public void notifyBPMObserver(){
        for(BPMObserver o:bpms){
            o.updateBPM();
        }
    }

    public void notifyBeatObserver(){
        for(BeatObserver o:beats){
            o.updateBeat();
        }
    }

    @Override
    public void meta(MetaMessage meta) {
        if(meta.getType()==47){
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    public void beatEvent(){
        notifyBeatObserver();
    }

    public void setUpMidi(){
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart(){
        int[] trackList = {35,0,46,0};
        sequence.deleteTrack(null);
        track = sequence.createTrack();
        makeTracks(trackList);
        track.add(makeEvent(192,9,1,0,4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list){
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if(key!=0){
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(144,9,key,100,i+1));
            }
        }
    }

    public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}

