package com.pacmanface.djmvc;

import com.pacmanface.djmvc.interfaces.BeatModel;
import com.pacmanface.djmvc.interfaces.BeatController;

public class TestBeats{
	public static void main(String[]args){
		BeatModel model = new BeatModelImpl();
		BeatController controller = new BeatControllerImpl(model);
	}  
}
