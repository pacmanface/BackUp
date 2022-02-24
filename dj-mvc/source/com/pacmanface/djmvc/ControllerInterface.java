package com.pacmanface.djmvc;

public interface ControllerInterface{
	void start();
	void stop();
	void setBPM(int bmp);
	void increaseBPM();
	void decreaseBPM();
}
