package com.pacmanface.djmvc.heartmode;

import com.pacmanface.djmvc.interfaces.BPMObserver;
import com.pacmanface.djmvc.interfaces.BeatObserver;

public interface HeartModel {
    int getHeartRate();
    void registerObserver(BPMObserver o);
    void registerObserver(BeatObserver o);
    void removeObserver(BPMObserver o);
    void removeObserver(BeatObserver o);
}
