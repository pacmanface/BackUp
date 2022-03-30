package com.pacmanface.djmvc;

import com.pacmanface.djmvc.interfaces.BeatModel;
import com.pacmanface.djmvc.interfaces.BeatController;

public class BeatControllerImpl implements BeatController{

    BeatModel model;
    BeatView view;

    public BeatControllerImpl(BeatModel m){
        model = m;
        view = new BeatView(model,this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.init();
    }

    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }
    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm+1);
    }

    @Override
    public void decreaseBPM() {
		int bpm = model.getBPM();
        model.setBPM(bpm-1);
    }


}
