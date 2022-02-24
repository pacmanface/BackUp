package com.pacmanface.djmvc;

public class BeatController implements ControllerInterface{

    BeatModelInterface model;
    DjView view;

    public BeatController(BeatModelInterface m){
        model = m;
        view = new DjView(model,this);
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
