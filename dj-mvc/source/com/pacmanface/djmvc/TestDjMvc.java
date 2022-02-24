package com.pacmanface.djmvc;

public class TestDjMvc{
	public static void main(String[]args){
		BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
	}  
}
