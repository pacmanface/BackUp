package com.pacmanface.djmvc.heartmode;

import com.pacmanface.djmvc.interfaces.BeatController;

public class TestHearts {
    public static void main(String[] args) {
        HeartModel model = new HeartModelImpl();
        BeatController controller = new HeartControllerImpl(model);
    }
}
