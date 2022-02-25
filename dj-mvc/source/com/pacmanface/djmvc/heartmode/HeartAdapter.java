package com.pacmanface.djmvc.heartmode;

import com.pacmanface.djmvc.interfaces.BPMObserver;
import com.pacmanface.djmvc.interfaces.BeatModel;
import com.pacmanface.djmvc.interfaces.BeatObserver;

public class HeartAdapter implements BeatModel{
    HeartModel heart;

    public HeartAdapter(HeartModel h){
        heart = h;
    }

    @Override
    public void init() {}

    @Override
    public void on() {}

    @Override
    public void off() {}

    @Override
    public void setBPM(int bpm) {}

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        heart.registerObserver(o);        
    }

    @Override
    public void registerObserver(BPMObserver o) {
        heart.registerObserver(o);        
    }

    @Override
    public void removeObserver(BeatObserver o) {
        heart.removeObserver(o);        
    }

    @Override
    public void removeObserver(BPMObserver o) {
        heart.removeObserver(o);        
    }
}
