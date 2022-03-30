package com.pacmanface.djmvc.heartmode;

import java.util.ArrayList;
import java.util.Random;

import com.pacmanface.djmvc.interfaces.BPMObserver;
import com.pacmanface.djmvc.interfaces.BeatObserver;

public class HeartModelImpl implements HeartModel,Runnable{

    ArrayList<BPMObserver> bpms = new ArrayList<>();
    ArrayList<BeatObserver> beats = new ArrayList<>();
    
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModelImpl(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public int getHeartRate() {
        return 60000/time;
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpms.add(o);
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beats.add((BeatObserver) o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        bpms.remove(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beats.remove(o);
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
    public void run() {
        int lastrate = -1;
        for(;;){
            int change = random.nextInt(10);
            if(random.nextInt(2)==0){
                change = 0-change;
            }
            int rate = 60000/(time+change);
            if(rate<120 && rate>50){
                time+=change;
                notifyBeatObserver();
                if(rate!=lastrate){
                    lastrate=rate;
                    notifyBPMObserver();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
