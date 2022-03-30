package com.pacmanface.djmvc.heartmode;

import com.pacmanface.djmvc.BeatView;
import com.pacmanface.djmvc.interfaces.BeatController;

public class HeartControllerImpl implements BeatController {

    BeatView view;
    HeartModel model;

    public HeartControllerImpl(HeartModel m){
        model = m;
        view = new BeatView(new HeartAdapter(model), this);
        view.createView();
        view.createControls();
        view.disableStartMenuItem();
        view.disableStopMenuItem();
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void setBPM(int bmp) {
        // TODO Auto-generated method stub
    }

    @Override
    public void increaseBPM() {
        // TODO Auto-generated method stub
    }

    @Override
    public void decreaseBPM() {
        // TODO Auto-generated method stub
    }
    
}
