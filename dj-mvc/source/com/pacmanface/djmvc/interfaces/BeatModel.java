package com.pacmanface.djmvc.interfaces;

public interface BeatModel{
	//own model methods
	void init();
	void on();
	void off();
	void setBPM(int bpm);
	int getBPM();
	//observer pattern methods
	void registerObserver(BeatObserver o);
	void registerObserver(BPMObserver o);
	void removeObserver(BeatObserver o);
	void removeObserver(BPMObserver o);
}
