package com.pacmanface.djmvc.interfaces;

public interface BeatController{
	void start();
	void stop();
	void setBPM(int bmp);
	void increaseBPM();
	void decreaseBPM();
}
